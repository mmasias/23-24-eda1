import random
from data_structures.list import CustomList
from models.cliente import Cliente

class CentroComercial:
    LIMITE_COLA_EXTRA = 15
    MINIMO_ATENCION_EXTRA = 5

    def __init__(self, num_cajas=4):
        self.cola = CustomList()
        self.cajas = CustomList([0] * num_cajas)
        self.personas_atendidas = 0
        self.items_vendidos = 0
        self.minutos_sin_cola = 0
        self.caja_extra_activa = False
        self.clientes_atendidos_caja_extra = 0

    def procesar_llegada_clientes(self):
        if self.debe_llegar_nuevo_cliente():
            self.agregar_cliente_a_cola()

    def debe_llegar_nuevo_cliente(self):
        return random.random() < 0.4

    def agregar_cliente_a_cola(self):
        cliente = Cliente()
        self.cola.append(cliente)

    def procesar_atencion_clientes(self):
        self.evaluar_apertura_caja_extra()
        self.atender_clientes_en_cajas()
        self.evaluar_cierre_caja_extra()

    def evaluar_apertura_caja_extra(self):
        if len(self.cola) > self.LIMITE_COLA_EXTRA and not self.caja_extra_activa:
            self.abrir_caja_extra()

    def abrir_caja_extra(self):
        self.caja_extra_activa = True
        self.cajas.append(0)
        self.clientes_atendidos_caja_extra = 0

    def atender_clientes_en_cajas(self):
        for i, tiempo in enumerate(self.cajas):
            if tiempo == 0 and len(self.cola) > 0:
                self.atender_cliente(i)
            elif tiempo > 0:
                self.cajas[i] -= 1

    def atender_cliente(self, indice_caja):
        cliente = self.cola.pop(0)
        self.cajas[indice_caja] = cliente.packs - 1
        self.personas_atendidas += 1
        self.items_vendidos += cliente.packs
        if self.caja_extra_activa:
            self.clientes_atendidos_caja_extra += 1

    def evaluar_cierre_caja_extra(self):
        if self.caja_extra_activa and (self.clientes_atendidos_caja_extra >= self.MINIMO_ATENCION_EXTRA or len(self.cola) <= self.LIMITE_COLA_EXTRA):
            self.cerrar_caja_extra()

    def cerrar_caja_extra(self):
        self.caja_extra_activa = False
        self.cajas.pop(-1)

    def actualizar_estado_del_dia(self):
        if len(self.cola) == 0:
            self.minutos_sin_cola += 1

    def generar_resumen_final(self):
        return {
            'minutos_sin_cola': self.minutos_sin_cola,
            'personas_en_cola_final': len(self.cola),
            'personas_atendidas': self.personas_atendidas,
            'items_vendidos': self.items_vendidos
        }
