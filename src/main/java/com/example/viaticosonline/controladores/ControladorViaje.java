package com.example.viaticosonline.controladores;
import com.example.viaticosonline.entidades.Empleado;
import com.example.viaticosonline.entidades.Viaje;
import com.example.viaticosonline.servicios.ServicioEmpleado;
import com.example.viaticosonline.servicios.ServicioViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/uribe/viajes")
public class ControladorViaje {

    @Autowired
    ServicioViaje servicioViaje;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Viaje viaje){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioViaje.registrar(viaje));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje: anda pa alla bobo...}");
        }
    }

    @GetMapping
    public ResponseEntity <?> buscarViaje(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioViaje.buscarTodos());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{mensaje: anda pa alla bobo...}");
        }
    }
}
