interface MailService {
    fun sendEmail(from:String,to:String,subject: String,content:String){}
}