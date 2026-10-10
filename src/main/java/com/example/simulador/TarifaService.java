package com.example.simulador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    @Value("${institucion.nombre:Corporacion Unificada Nacional (CUN)}")
    private String nombreInstitucion;

    @Value("${tarifa.valor-credito:120000.0}")
    private double valorCredito;

    @Value("${tarifa.descuento-pronto-pago:0.10}")
    private double descuentoProntoPago;

    public double calcularLiquidacion(int numeroCreditos, boolean aplicaProntoPago) {
        double subtotal = numeroCreditos * valorCredito;

        if (aplicaProntoPago) {
            double descuento = subtotal * descuentoProntoPago;
            return subtotal - descuento;
        }

        return subtotal;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public double getDescuentoProntoPago() {
        return descuentoProntoPago;
    }
}