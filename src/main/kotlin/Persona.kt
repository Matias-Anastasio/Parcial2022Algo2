class Persona(
    val nombre: String,
    val email: String
){
    val regalosRecibidos = mutableListOf<Regalo>()
    var criterioParaRegalo :tipoDeGusto = Conformista

    fun cambiarCriterio(criterio : tipoDeGusto){
        criterioParaRegalo = criterio
    }

    fun aceptaRegalo(regalo: Regalo) : Boolean = criterioParaRegalo.leGusta(regalo)

    fun recibirRegalo(regalo: Regalo){
        regalosRecibidos.add(regalo)
    }
}

interface tipoDeGusto{
    fun leGusta(regalo: Regalo) : Boolean
}

object Conformista : tipoDeGusto{
    override fun leGusta(regalo: Regalo) = true
}

class Interesada(val costoMinimo : Int) : tipoDeGusto{
    override fun leGusta(regalo: Regalo): Boolean = regalo.esCaro(costoMinimo)
}

object Exigente:tipoDeGusto{
    override fun leGusta(regalo: Regalo): Boolean = regalo.esValioso()
}

class Marquera(val marcaPreferida : MARCA) : tipoDeGusto{
    override fun leGusta(regalo: Regalo): Boolean = regalo.esDeMarca(marcaPreferida)
}

class Combineta(val gustos : List<tipoDeGusto>) : tipoDeGusto{
    override fun leGusta(regalo: Regalo): Boolean = gustos.any{gusto->gusto.leGusta(regalo)}
}