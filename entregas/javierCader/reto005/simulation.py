from services.centro_comercial import CentroComercial
from utils.simulacion_display import SimulacionDisplay

def simular_dia():
    cc_alisal = CentroComercial()
    horas_del_dia = 12
    minutos_del_dia = horas_del_dia * 60

    for minuto in range(minutos_del_dia):
        ejecutar_ciclo_simulacion(cc_alisal, minuto)

    mostrar_resumen_del_dia(cc_alisal)

def ejecutar_ciclo_simulacion(centro_comercial, minuto):
    centro_comercial.procesar_llegada_clientes()
    centro_comercial.procesar_atencion_clientes()
    centro_comercial.actualizar_estado_del_dia()
    SimulacionDisplay.mostrar_estado(centro_comercial, minuto)

def mostrar_resumen_del_dia(centro_comercial):
    SimulacionDisplay.mostrar_resumen_final(centro_comercial)

if __name__ == "__main__":
    simular_dia()
