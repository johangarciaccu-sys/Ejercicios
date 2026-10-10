package com.example.simulador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerComponent implements CommandLineRunner {

    @Autowired
    private TarifaService tarifaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=======================================================");
        System.out.println("  SIMULADOR DE TARIFAS Y LIQUIDACIÓN INSTITUCIONAL");
        System.out.println("=======================================================");
        System.out.println("Institución: " + tarifaService.getNombreInstitucion());
        System.out.println("Valor del crédito: $" + String.format("%,.2f", tarifaService.getValorCredito()) + " COP");
        System.out.println("Descuento pronto pago: " + (tarifaService.getDescuentoProntoPago() * 100) + "%");
        System.out.println("-------------------------------------------------------");

        int creditosEstudiante = 16;

        double totalSinDescuento = tarifaService.calcularLiquidacion(creditosEstudiante, false);
        double totalConDescuento = tarifaService.calcularLiquidacion(creditosEstudiante, true);

        System.out.println(" Simulación para matrícula de " + creditosEstudiante + " créditos:");
        System.out.println("   - Liquidación Tarifa Plena:        $" + String.format("%,.2f", totalSinDescuento) + " COP");
        System.out.println("   - Liquidación con Pronto Pago:     $" + String.format("%,.2f", totalConDescuento) + " COP");
        System.out.println("=======================================================\n");
    }
}