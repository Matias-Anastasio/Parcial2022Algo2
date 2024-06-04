import java.time.DayOfWeek
import java.time.LocalDate
import kotlin.math.cos

enum class ORIGEN{
    NACIONAL,
    EXTRANJERO
}

enum class MARCA{
    NikeFeraldy,
    Kodak,
    Jordache,
    Lee,
    Charro,
    MotorOil,
    Papapp,
    OTRA
}

abstract class Regalo(
    val costo: Int,
    val marca: MARCA
) {

    abstract fun criterioValioso() : Boolean

    fun esValioso() = costo> 5_000 && criterioValioso()

    fun esDeMarca(marcaAEvaluar: MARCA) = marcaAEvaluar == marca

    fun esCaro(costoMinimo: Int) = costo > costoMinimo
}

class Ropa(costo: Int, marca: MARCA) : Regalo(costo, marca) {
    val marcasValiosas = listOf(MARCA.Jordache,MARCA.Lee,MARCA.Charro,MARCA.MotorOil)
    override fun criterioValioso() : Boolean = marcasValiosas.contains(marca)
}

class Juguete(val anioDeLanzamiento : Int, costo: Int, marca: MARCA) : Regalo(costo, marca){
    override fun criterioValioso(): Boolean = anioDeLanzamiento < 2_000
}

class Perfume(val origen :ORIGEN,costo: Int, marca: MARCA) : Regalo(costo, marca){
    override fun criterioValioso(): Boolean = origen == ORIGEN.EXTRANJERO
}

class Experiencia(val fecha: LocalDate,costo: Int, marca: MARCA) : Regalo(costo, marca){
    override fun criterioValioso(): Boolean = fecha.dayOfWeek == DayOfWeek.FRIDAY
}

object Voucher : Regalo(2000,MARCA.Papapp){
    override fun criterioValioso(): Boolean = false
}


