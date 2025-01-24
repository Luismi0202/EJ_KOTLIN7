class Cuenta(
    val numCuenta: Int,
    val saldoInicial: Double = 0.0
) {
    var saldoDisponible:Double = 0.0

    init{
        saldoDisponible = saldoInicial
    }
    fun consultarSaldo():Double{
        return saldoDisponible
    }


    fun recibirAbonos(dinero:Double){ saldoDisponible += dinero }

    fun realizarPagos(dinero:Double){ saldoDisponible -= dinero }
}