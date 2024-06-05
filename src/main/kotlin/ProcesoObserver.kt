interface ProcesoObserver{
    fun regaloHecho(proceso: Proceso, persona: Persona, regalo: Regalo)
}

class NotificadorObserver(val mailSender: MailSender) : ProcesoObserver{
    override fun regaloHecho(proceso: Proceso, persona: Persona, regalo: Regalo) {
        mailSender.sendEmail(Mail(
            from = "regalo@navidad.com",
            to = persona.email,
            subject = "Ha recibido un regalo",
            content = "Usted ha recibido un regalo por navidad"
        ))
    }
}

class EnviosObserver(val servicioDeDespacho: ServicioDeDespacho) : ProcesoObserver{
    override fun regaloHecho(proceso: Proceso, persona: Persona, regalo: Regalo) {
        servicioDeDespacho.despachar(InformacionDeEntrega(
            empresa= "El Reno Loco",
            direccion = persona.direccion,
            destinatario = persona.nombre,
            dni = persona.dni,
            codigo = regalo.codigo
        ))
    }
}

class IneresadaObserver : ProcesoObserver{
    override fun regaloHecho(proceso: Proceso, persona: Persona, regalo: Regalo) {
        if (regalo.costo>10_000)
            persona.cambiarCriterio(Interesada(5_000))
    }
}