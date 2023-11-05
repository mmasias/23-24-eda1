class SimulacionDisplay:
    @staticmethod
    def mostrar_estado(centro_comercial, minuto):
        cajas = centro_comercial.cajas
        cola = len(centro_comercial.cola)

        # Generate a string representation of the checkout counters with the number of packs
        cajas_str = ''.join(f'[{caja if caja > 0 else " "}]' for caja in cajas)

        # Generate a string representation of the queue
        cola_str = ''.join('🚶' for _ in range(cola))

        print(f"\nMinuto {minuto+1}:")
        print(f"🛒 Estado de las cajas: {cajas_str}")
        print(f"🔢 Número de personas en cola: {cola} {cola_str}")
        
        if cola > 0:
            primer_cliente_packs = centro_comercial.cola[0].packs
            print(f"Primer cliente en la cola tiene: {primer_cliente_packs} packs {'📦' * primer_cliente_packs}")

    @staticmethod
    def mostrar_resumen_final(centro_comercial):
        resumen = centro_comercial.generar_resumen_final()
        print("\n📊 Resumen al finalizar el día:")
        print(f"⏳ Número de minutos en que no hubo nadie en cola: {resumen['minutos_sin_cola']}")
        print(f"🏁 Número de personas en cola al finalizar el día: {resumen['personas_en_cola_final']}")
        print(f"🙋‍♂️ Número de personas atendidas durante el día: {resumen['personas_atendidas']}")
        print(f"📈 Número de items vendidos en el día: {resumen['items_vendidos']}")
