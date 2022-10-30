package com.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Vector

//Es una forma de simplificar el código
typealias aliasObjeto = Subclases.subClass

//El objetivo es usarlo en cuesitones más complejas de código
typealias aliasDato = MutableMap<Pair<Int,Boolean>,List<Map<Pair<Int,Vector<List<Int>>>,Boolean>>>
typealias funcionAliada = (a: Int,b: Int) -> Int

//Comandos de teclado

/*
    ATAJOS DE BUSQUEDA
    CTRL + F // Buscar texto
    CTRL + RC // Buscar declaración
    SHIFT + SHIFT // Buscar entre archivos
    ESC // Salir de pestaña actual
    CTRL + R // Reemplazar texto en la página actual

    ATAJOS DE MANIPULACIÓN DE CÓDIGO
    ALT + SHIFT + UP // Desplazar código ya sean líneas o bloques hacia arriba
    ALT + SHIFT + DOWN // " " hacia abajo
    CTRL + SHIFT + UP // Desplazamos directamente movemos funciones
    CTRL + SHIFT + DOWN // " " hacia abajo
    CTRL + Y // Eliminar lineas
    CTRL + D // Duplicar linea
    ALT + UP/DOWN // Desplazandome entre funciones o declaraciones
    CTRL + - // Minimizar funciones y con doble - minimizamos al padre
    ALT + RIGHT / LEFT // Nos desplazamos entre archivos abiertos en la cabecera
    CTRL + TAB // Abrimos un menú para poder desplazar entre TODOS los archivos


 */


class MainActivity : AppCompatActivity() {
    //Funciona con clases y datos no primarios
    private lateinit var sportman : Athlete
    //Objeto anonimo y se declara antes de cualquier función
    object Anonimo{
        private var nombre = "Daniel"
        fun saludo(){
            println("Mi nombre es $nombre")
        }
    }
    //private var sportman2 : Athlete
    private lateinit var cadena : String
    private var booli3 : Boolean = true
    //Aquí creamos funciones extras a un tipo de dato
    private fun String.noSpaces() : String{
        return this.replace(" ","")
    }
    private fun IntArray.show(){
        print("{")
        for(i in this)
            print("$i ")
        println("}")
    }
    /*
    En el parámetro que recibe como "funcion" se especifica los campos
    que lleva la función que va a recibir así como el valor de retorno
     */
    private fun calculadora(numero1: Int,numero2: Int,funcion: (Int,Int)->Int) : Int{
        return funcion(numero1,numero2)
    }

    private fun suma(numero1: Int,numero2: Int) : Int{
        return numero1 + numero2
    }
    private fun resta(numero1: Int,numero2: Int) : Int{
        return numero1 - numero2
    }
    private fun inMexico(height: Float) : Boolean{
        return height >= 1.6f
    }
    private fun inUSA(height: Float) : Boolean{
        return height >= 1.7f
    }
    private fun recorrerArray(arr : IntArray, funcion: (Int) -> Unit){
        for (i in arr){
            funcion(i)
        }
    }
    //El any implica que puede devolver cualquier cosa
    private fun value_try(a: Int, b: Int): Any{
        var er =
            try{
                a/b
            }catch (error: Exception){
                "Error"
            }
        return er;
    }
    class passwordException(message : String) : Exception(message){

    }
    //Es otra forma de retornar los valores, se asemeja a F#
    private fun multiplicacion(numero1: Int, numero2: Int) = numero1 * numero2
    private fun divide(numero1: Int,numero2: Int) = numero1 / numero2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var Cadena = "Hola Mundo"
        println(Cadena)
        Cadena = Cadena.noSpaces()
        println(Cadena)
        val Daniel : Person = Person()
        Daniel.setHeight(1.60f)
        if(Daniel.alive) println("It is alive")
        else println("He's dead")
        Daniel.die()
        if(Daniel.alive) println("It is alive")
        else println("He's dead")
        println(Daniel.getName() + " " + Daniel.getPassport())
        var newPokemon : Pokemon = Pokemon()
        val nuevoAtleta : Athlete = Athlete("Daniel","ASDF09","BMX")
        println(nuevoAtleta.alive)
        println(nuevoAtleta.getName())
        println(nuevoAtleta.getPassport())
        println(nuevoAtleta.sport)
        nuevoAtleta.die()
        println(nuevoAtleta.alive)
        println(nuevoAtleta.getName())
        println(nuevoAtleta.getPassport())
        println(nuevoAtleta.sport)
        var x = Subclases()
        println(x.presentar())
        var y = Subclases.subClass()
        y.ret()
        var z = Subclases().innerClass()
        z.ret()
        //Clases anónimas
        Anonimo.saludo()
        var sol: star = star("Sun",1500f)
        println(sol)
        sol.alive = false
        println(sol.alive)
        var hoy = days.MONDAY
        var semana = days.values()
        for(i in semana) println("$i  " + i.ordinal)
        println(days.valueOf("SUNDAY"))
        println(hoy.name + " " + hoy.ordinal)
        println(hoy.saludo())
        println(hoy.time)
        for(i in semana){
            if(i.lab) println("YYYYY puto, te toca trabajar el $i, ${i.time} horas")
            else println("Te salvaste puto")
        }
        var array1 : Array<Int> = arrayOf(1,2,3,4)
        var array2 = IntArray(3)
        var array3 :IntArray = intArrayOf(1,2,3,4)
        println("Hola: "); array3.show();
        //Aplicando funciones de orden superior a objetos y funciones
        println(calculadora(5,6,::suma))
        println(Daniel.checkPolice(::inMexico))
        println(Daniel.checkPolice(::inUSA))

        //Lambdas

        //Almacenamos la operación de la función y puede modificarse a sí misma
        //Las funciones pueden ser más complejas, no necesariamente
        //deben ser tan simples
        //Y la podemos modificar en cualquier momento
        var funcion = { x: Int, y: Int -> x + y}
        println(calculadora(40,40,funcion))
        funcion = { x: Int, y: Int -> x - y}
        println(calculadora(40,40,funcion))

        //Funciones lambdas anónimas
        println(calculadora(40,40,{x: Int, y: Int -> x + y}))
        println(calculadora(40,40,{x: Int, y: Int -> x - y}))

        //Las expresiones lambda se asemejan mucho a las funciones en F#

        println(calculadora(2,4,{value: Int, pot: Int -> var res = 1; for( i in 1..pot) res*=value; res }))
        /*
        println(calculadora(2,4,{
            value: Int, pot: Int ->
               var res = 1
               for( i in 1..pot) res*=value
               res
        }))
         */
        //Así mismo las lambdas pueden ir fuera del paréntesis
        println(calculadora(4,6){
                value: Int, pot: Int ->
            var res = 1
            for(i in 1..pot) res *= value
            res
        })
        //Esta es una expresión lambda que permite llenar el arreglo con 5's
        var array4 = IntArray(10){5}
        array4.show()
        var array5 = IntArray(10){
            //Existe un iterador y que es el parámetro de la lambda y en este caso
            //se llama "it"
            it
        }
        array5.show()
        var array6 = IntArray(10){
            it * 2
        }
        array6.show()
        //Aquí renombramos el parámetro de la lambda
        var array7 = IntArray(10){ i -> i * 3}
        array7.show()

        var suma = 0
        recorrerArray(array7){
            suma += it
        }
        println(suma)

        //Alias, forma de renombrar datos complejos a datos simples
        //Así mismo los alias también puede ser usado en funcinoes
        var dato: aliasDato

        //De-estructuración
        //Puedo acceder a todos los elementos
        var (name_star2,radius2,galaxy2) = star("Sol2",1239f,"Lactea2")
        println(name_star2 + " " + radius2 + " " + galaxy2)
        //Accedo solo al primero y al segundo
        var (name_star3,radius3) = star("Sol3",1239f,"Lactea3")
        println(name_star3 + " " + radius3 + " " )
        //Accedo al primero y al último
        //Con el guión bajo, podemos omitir almacenar ciertos campos
        var (name_star4, _ ,galaxy4) = star("Sol4",1239f,"Lactea4")
        println(name_star4 + " " + galaxy4 + " "  )

        var componente = star("sol5",12829383f,"Lactea5")
        println(componente.component1())
        println(componente.component2())
        println(componente.component3())
        /*
        val saludos : MutableMap<String,List<String>> = {("Hola",ListOf("Hola perro"))}
        for((id,palabra) in saludos)
            println("$id $palabra)
         */

        /*
        Tipos de Errores:
            * NullPointerException
            * ArithmeticException
            * SecurityException
            * ArrayIndexOutOfBoundException
         */

        try{
            println(5/5)
        }catch(error: Exception){
            println("Error, eres puto")
        }finally{
            //Finaly siempre ejecuta código, independientemente si está bien o mal
            println("Se ve que eres puto")
        }
        println("${value_try(10,2)}  ${value_try(10,0)}")


        //El throw es una forma de debugear más que nada para nosotros y no tanto para el
        //Usuario ya que detiene toda la ejecución
        //val password : String = "12345"
        /*
            if( password .length < 6 ) throw passwordException("Small password")
            else println("Correct password")
         */

        Anonimo.let{
            it.saludo()
        }
        //Forma de acceder y realizar varias acciones dentro de un objeto de forma simple
        nuevoAtleta.let{
            it.sport = "Football"
            it.alive = false
            it.height = 12f
        }
        //Funciona igual que let, pero con la palabra reservada this
        nuevoAtleta.apply {
            this.die()
            this.sport = "Soccer"
            this.alive = false
        }

        var temp = Person("Daniel","adfasd2",98f).apply {
            this.die()
            this.height = 12f
            this.alive = true
        }.also{
            it.height = 13f
            it.alive = false
        }

        //Aquí no guardamos lo de Person en temp2, simplemente lo ejecutamos, por la instrucción
        //run, lo mismo sucede con with
        //Por lo que temp2 y temp3 se guardará el valor string que está al final, como las expresiones lambda
        var temp2 = Person("asdfjla", "haksjdf", 90f).run{
            this.setName("Puto")
            this.alive = false
            "Eres puto"
        }
        var temp3 = with(Person("asdfjla", "haksjdf", 90f)){
            this.setName("Puto")
            this.alive = false
            "Eres puto"
        }


        //Operador "Elvis", es muy útil para cuando necesitamos comprobar valores
        var pais : String? = "Rusia"
        //Derecha if false, izquierda if true
        pais = pais?.uppercase() ?: "Desconocido"
        println(pais)
        var ciudad : String? = null
        ciudad = ciudad?.uppercase() ?: "No existe la ciudad"
        println(ciudad)

        //lateinit, no manda error al no inicializar ya que al estar dentro de una función
        //No existe tanto problema, mientras que cuando es fuera de la función si existe el problema
        //Y es donde podemos usar el lateinit

        var booli : Boolean
        var booli2 : Person

        //Lazy funciona con val unicamente y en este caso que no se inicializa, no se asigna el valor que le di
        //Y se inicializa en cuanto yo le de un valor directamente
        //Se puede usar para optimizar el proceso de ejecución cuando contamos con bloques muy pesados de código
        //Para evitar ejecutarlo en el momento que no lo necesito
        val calle : String by lazy { "Nueva" }
        println(calle)
        if(1==1) println("si")
        //Funciones de orden superior
        /*
            Son funciones que reciben funciones como parámetros y son funciones que
            se usan dentro del código de dicha función
         */
        //Funciones elementales para poder ejecutar el proceso de vida de una aplicación
        //El proceso de vida se basa en onCreate(),onStart(),onResume()
        //Sí se cumplen entramos en la app, en caso de que se interrumpa la ejecución por otra actividad
        //Entraremos en el onPause() y después en el onStop(), sí se reanuda la actividad después, retomamos desde onRestart() y luego onStart()
        //En caso de que finalicemos totalmente entramos en onDestroy() que funciona para liberar toda la memoria usada por la aplicación
        /*override fun onStart(){
            super.onStart()
        }
        override fun onPause(){
            super.onPause()
        }*/
        //Fragments - Fragmentos
        //Son básicamente subactividades
        //Tiene un proceso similar a las Activities, sin embargo tiene su propio ciclo de vida más complejo


        //Las view son elementos que podemos implementar o usar directamente de la clase view, para generar elementos visibles para el
        //usuario, donde existen por grupos o individuales

        //Viewgroups son invisibles




    }
}