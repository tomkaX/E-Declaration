//module.exports = function (){


var mailer =  require("nodemailer");
var fs      = require("fs");




// Use Smtp Protocol to send Email
var smtpTransport = mailer.createTransport("SMTP",{
    service: "Gmail",
    auth: {
        user: "tomacolyada@gmail.com",
        pass: "nm235360"
    }
});
var ht= "<h1><b>Доброго дня!</b></h1>"
var ht1="<p>В результаті проведеного аналізу поданих декларацій система знайшла осіб які підлягають більш детальній перевірці</p>"
var ht2="<p>Вся інформація знаходиться в додатку до листа - будь ласка ознайомтесь з нею</p>"
var ht3= "<span><br>З повагою</br>"
var ht4= "<span><p>Команда E-Declaration</p>"
var ht5= "<span><a>e-declaration.com.ua</a>"
var mail = {
    from: "Tomka Koliada <tomacolyada@gmail.com>",
    to: "tomacolyada@gmail.com",
    subject: "E-Declaration project ",
    text: "",
    html:ht +ht1+ht2+ht3+ht4+ht5,
    attachments: [
   {fileName: 'declaration.pdf', contents:'hhhh'},
  // {fileName: 'deerWithEyes.jpg', filePath: 'deer.jpg'}
 ]
    //html = mail.html;
  //  attachments = @getAttachments(html)
    //html: mail.html;
}

document.guerySelector('#send_email').addEventListener('click', function(){
  console.log('ready!')
});

smtpTransport.sendMail(mail, function(error, response){
    if(error){
        console.log(error);
    }else{
        console.log("Message sent: " + response.message);
    }

    smtpTransport.close();
});
//}
