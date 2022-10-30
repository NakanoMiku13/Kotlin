package com.example.ejerciciopoo

open class SportMan(
    protected var name : String = "Empty Name",
    protected var height : Float = 1f,
    protected var weight : Float = 50f,
    protected var age : Int = 18
) {
    fun rest(){
        println("You are resting, take it easy.")
    }
    open fun fight(){
        print("I'm going to ")
    }
    internal fun getName() : String{
        return this.name
    }
    internal fun getHeight() : Float{
        return this.height
    }
    internal fun getWeight() : Float{
        return this.weight
    }
    internal fun getAge() : Int{
        return this.age
    }
    internal fun setName(newName : String){
        this.name = newName
    }
    internal fun setHeight(newHeight : Float){
        this.height = newHeight
    }
    internal fun setWeight(newWeight : Float){
        this.weight = newWeight
    }
    internal fun setAge(newAge : Int){
        this.age = newAge
    }
}
class Runner(
    private var style: String = "",
    private var speed: Float = 0f,
    name: String = "",
    height: Float = 0f,
    weight: Float = 0f,
    age: Int = 0
) : SportMan(name,height,weight,age){
    fun run(){
        println("You are running with the style: $style and a speed of $speed")
    }
    override fun fight() {
        super.fight()
        print("run\n")
    }
    fun getStyle(): String{
        return this.style
    }
    fun setStyle(newStyle: String){
        this.style = newStyle
    }
}
class Ciclist(
    private var bicicleType: String?,
    private var speed : Float = 1.0f,
    name: String = "",
    height: Float = 0f,
    weight: Float = 0f,
    age: Int = 0
) : SportMan(name,height,weight,age){
    fun riding(){
        println("You are using the bike $bicicleType and riding at $speed")
    }
    override fun fight() {
        super.fight()
        print("ride\n")
    }
    fun getBicicleType() : String?{
        return this.bicicleType
    }
    fun getSpeed() : Float{
        return this.speed
    }
    fun setBicicleType(bicicle: String?){
        this.bicicleType = bicicle
    }
    fun setSpeed(speed: Float){
        this.speed = speed
    }
}
class Swimmer(
    private var style : String = "",
    private var speed : Float = 1.0f,
    name: String = "",
    height: Float = 0f,
    weight: Float = 0f,
    age: Int = 0
) : SportMan(name,height,weight,age){
    override fun fight() {
        super.fight()
        print("swim\n")
    }
    fun swim(){
        println("Swimming at $speed using the technique $style")
    }
    fun getStyle(): String{
        return this.style
    }
    fun setStyle(newStyle: String){
        this.style = newStyle
    }
    fun getSpeed() : Float{
        return this.speed
    }
    fun setSpeed(speed: Float){
        this.speed = speed
    }
}