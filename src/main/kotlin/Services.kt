
data class Mail (val from:String,val to:String,val subject: String, val content:String)

interface MailSender {
    fun sendEmail(mail: Mail){}
}

data class InformacionDeEntrega(val empresa: String,val direccion : String,val destinatario: String,val dni:Int,val codigo : String)

interface ServicioDeDespacho{
    fun despachar(informacionDeEntrega: InformacionDeEntrega){}
}