package com.poo
//Existen parametros optativos y obligatorios
//Estos son optativos
open class Person(protected var name: String = "Anon", protected var passport: String? = null, var height: Float = 1.6f) : AbstractClass(), test {
    var alive : Boolean = true
    open fun die(){
        alive = false
    }
    override var vari: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    //Se usa internal cuando hablamos de variables que si se pueden heredar (Protected)
    //Sin embargo la función se confunde y solo pasa con funciones get y set
    //Y son especiales porque hacen uso del encapsulamiento
    internal fun getName():String{
        return this.name
    }
    internal fun setHeight(height: Float){
        this.height = height
    }
    internal fun getPassport():String?{
        return this.passport
    }
    internal fun setName(name:String){
        this.name = name
    }
    internal fun setPassport(passport: String?){
        this.passport = passport
    }
    //Funciones de orden superior en clases
    fun checkPolice(fn: (Float)->Boolean):Boolean{
        return fn(height)
    }
}
abstract class AbstractClass(){
    fun thanks(){
        println("Holi")
    }
}
class claseTemporal(){
    fun HolaMundo(){
        println("Hola mundo")
    }
}
class Athlete(
    name: String = "",
    passport: String? = null,
    var sport: String = ""
    ) : Person(name,passport)
{
    //Lateinit permite inicializar variables posteriormente (UNICAMENTE CLASES)
    lateinit var initlater : claseTemporal
    fun Athlete(name: String, passport: String?,sport: String){
        this.name = name
        this.passport = passport
        this.sport = sport
    }
    //Esto es polimorfismo y permite modificar funciones heredadas
    override fun die(){
        //Con super hacemos llamada al padre de donde hereda las funciones y propiedades
        //En pocas palabras es lo mismo que this, pero para el padre
        super.die()
        this.name = "Dead"
        this.passport = "None"
    }
}
//Interfaces no tienen constructures y sirven para hacer una "herencia" múltiple
//Así que tampoco puede tener inicializadas las variables
interface test{
    var vari : Int
    fun testi(){

    }
}
class Subclases{
    private var name = "Hola"
    fun presentar():String{
        return this.name
    }
    //Con inner puedo acceder a los datos de la clase padre
    inner class innerClass(){
        fun ret(){
            println("Soy una función hija y mi padre es ${name}")
        }
    }
    class subClass(){
        fun ret(){
            println("Esta es una subclase")
        }
    }
}
//Es un conjunto de datos no existen funcionalidades y existen únicamente atributos sin métodos
//(DATACLASS)
//Obligatoriamente necesita un val o var en el constructor
//Se le pueden implementar métodos, pero no es su objetivo, simplemente
//para guardar datos
data class star(
     val name : String = "Centauri",
     val radius : Float = 1.0f,
     val galaxy : String = "Milky Way"
){
    var alive = true
}
//Admite funciones, metodos y atributos
//Sin embargo, los atributos son constantes
enum class days(val lab: Boolean, val time: Int){
    //Se le pueden poner propiedades a cada valor
    MONDAY(true,8),
    TUESDAY(true,7),
    WEDNESDAY(false,0),
    THURSDAY(true,9),
    FRIDAY(false,0),
    SATURDAY(false,0),
    SUNDAY(false,0);
    //SIEMPRE QUE USEMOS ENUM CLASS Y USAMOS UN WHEN, TENEMOS QUE USAR SIEMPRE
    //ELSE AL FINAL Y TODAS LAS POSIBILIDADES
    fun saludo(){
        when(this){
            MONDAY -> println("Me agradas")
            TUESDAY -> println("No me agradas")
            WEDNESDAY -> println("Es miercoles")
            THURSDAY,SATURDAY,SUNDAY -> println("Ya quiero comer")
            FRIDAY -> println("YA ES VIERNEEES")
            else -> println("Te odio xd")
        }
    }
}