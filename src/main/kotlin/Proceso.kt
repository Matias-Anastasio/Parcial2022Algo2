class Proceso{

    val regalos = mutableListOf<Regalo>()
    val registroDeRegalos = mutableMapOf<Persona,MutableList<Regalo>>()
    val observers = mutableListOf<ProcesoObserver>()



    fun agregarRegalo(regalo: Regalo){
        regalos.add(regalo)
    }

    fun agregarObserver(observer: ProcesoObserver){
        observers.add(observer)
    }

    fun removerObserver(observer: ProcesoObserver){
        observers.remove(observer)
    }

    fun regalarA(persona: Persona){
        val regaloAdecuado = buscarRegalo(persona)
        registrarRegalo(persona,regaloAdecuado)
    }

    fun buscarRegalo(persona: Persona) : Regalo{
        regalos.forEach{regalo->
            if (persona.aceptaRegalo(regalo)) return regalo
        }
        return Voucher
    }

    fun registrarRegalo(persona: Persona,regalo: Regalo){
        registroDeRegalos.computeIfAbsent(persona) {mutableListOf()}.add(regalo)
        notificarObservers(persona,regalo)
    }

    fun notificarObservers(persona: Persona,regalo: Regalo){
        observers.forEach{it.regaloHecho(this,persona,regalo)}
    }
}