package com.example.mscorreo2.principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enviarCorreo")
//@FeignClient(name="servicio-correo",url="localhost:8090")
public class EnviarCorreo {

    @Autowired
    private JavaMailSender mail;

    @ResponseBody
    @GetMapping(value = {"/",""})
    public ResponseEntity<?> enviar_correo(@RequestParam(value = "correo") String correo,
                                           @RequestParam(value = "fecha") String fecha,
                                           @RequestParam(value = "estado") String estado,
                                           @RequestParam(value = "dispositivo") String dispositivo){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(correo);
        email.setFrom("josueromero1901@gmail.com");
        String saltos = "\n\n";
        String textoMensaje="";
        email.setSubject("Solicitud de dispositivo");
        if (estado.equals("Habilitado")){
             textoMensaje = "El dispositivo " + dispositivo + " fue " + estado
                    + saltos + "El dia máximo de devolucion es " + fecha +saltos+"Que tenga un Buen dia";
        }
        if (estado.equals("Rechazado")){
            textoMensaje ="El dispositivo " + dispositivo + " fue " + estado
                    + saltos + "verifique en la aplicacion cual fue la observacion";
        }

        email.setText(textoMensaje);
        mail.send(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
