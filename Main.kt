
fun main(){
    var persona1 = Persona("49988566K","Luismi")
    var cuenta1 = Cuenta(1)
    var cuenta2 = Cuenta(2,700.0)

    persona1.anadirCuenta(cuenta1)
    persona1.anadirCuenta(cuenta2)

    cuenta1.recibirAbonos(1100.0)
    cuenta2.realizarPagos(750.0)
    println(if(persona1.personaMorosa()) "Es moroso" else "No es moroso")

    persona1.transferenciaBancaria(persona1,cuenta1,cuenta2,800.0)
    println(if(persona1.personaMorosa()) "Es moroso" else "No es moroso")
    println(persona1)
}