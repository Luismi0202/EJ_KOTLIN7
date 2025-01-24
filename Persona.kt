class Persona(
    val DNI: String,
    val nombre: String
) {
    var cuentas: Array<Cuenta?> = arrayOfNulls<Cuenta>(3)
    fun anadirCuenta(cuenta:Cuenta):String?{
        if(limitePermitido(cuentas)){
            return "NO PUEDES CREAR MÁS CUENTAS, YA HAY 3"
        }
        var contador = 0
        var cuentaAnadida = false
        do{
            if(cuentas[contador] == null){
                cuentas[contador] = cuenta
                cuentaAnadida = true
            }
            else{
                contador++
            }
        }while(!cuentaAnadida)
        return null
    }

    private fun limitePermitido(Cuentas: Array<Cuenta?>):Boolean{
        var contador = 0
        for(cuenta in Cuentas){
            if(cuenta != null){
                contador++
            }
        }
        return contador == 3
    }

    fun personaMorosa():Boolean{
        var soy_moroso = false
        for(i in 0..2){
            if(cuentas[i]!= null){
                if(cuentas[i]!!.saldoDisponible < 0.0){
                    soy_moroso = true
                }
            }
        }
        return soy_moroso
    }

    private fun comprobarTransferencia(saldoDisponible:Double,cantidad:Double):Boolean{
        return if(saldoDisponible < cantidad) false else true
    }

    private fun comprobarCuentaAsociada(cuenta:Cuenta, persona:Persona):Boolean{
        for(i in 0..2){
            if(persona.cuentas[i]==cuenta) return true
        }
        return false
    }

    private fun contarCuentas():Int{
        var contador = 0
        for(cuenta in cuentas){
            if(cuenta!=null){
                contador++
            }
        }
        return contador
    }

    override fun toString(): String {
        return "Nombre: $nombre DNI: $DNI Cuentas: ${contarCuentas()}"
    }

    fun transferenciaBancaria(personaB:Persona, cuenta1:Cuenta, cuenta2:Cuenta, dineroTransferencia:Double):Boolean{
        if(comprobarCuentaAsociada(cuenta2,personaB) && cuenta1 in cuentas){
            if(comprobarTransferencia(cuenta1.saldoDisponible,dineroTransferencia)){
                cuenta1.realizarPagos(dineroTransferencia)
                cuenta2.recibirAbonos(dineroTransferencia)
                println("¡La operación se ha realizado con éxito! El dinero ha sido recibido por ${personaB.nombre}")
                return true
            }
        }
        return false
    }
}