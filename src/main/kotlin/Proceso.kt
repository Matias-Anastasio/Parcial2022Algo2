import com.sun.jdi.Value

class Regalador{

    val personas = mutableListOf<Persona>()
    val regalos = mutableListOf<Regalo>()
    val registroDeRegalos = mutableMapOf<Persona,MutableList<Regalo>>()
    val observers = mutableListOf<RegaladorObserver>()

    fun agregarPersona(persona: Persona){
        personas.add(persona)
    }

    fun agregarRegalo(regalo: Regalo){
        regalos.add(regalo)
    }

    fun agregarObserver(observer: RegaladorObserver){
        observers.add(observer)
    }

    fun removerObserver(observer: RegaladorObserver){
        observers.remove(observer)
    }

    fun regalar(){
        personas.forEach{persona -> persona.recibirRegalo(buscarRegalo(persona))}

    }

    fun buscarRegalo(persona: Persona) : Regalo{
        regalos.forEach{regalo->
            if (persona.aceptaRegalo(regalo)) return regalo
        }
        return Voucher
    }
}

interface RegaladorObserver{
    fun regalosHechos(regalador: Regalador,persona: Persona,regalo: Regalo)
}

class NotificadorObserver : RegaladorObserver{
    override fun regalosHechos(regalador: Regalador, persona: Persona, regalo: Regalo) {

    }
}

class EnviosObserver : RegaladorObserver{
    override fun regalosHechos(regalador: Regalador, persona: Persona, regalo: Regalo) {

    }
}

class RegistroObserver : RegaladorObserver{
    override fun regalosHechos(regalador: Regalador, persona: Persona, regalo: Regalo) {
        TODO("Not yet implemented")
    }
}

