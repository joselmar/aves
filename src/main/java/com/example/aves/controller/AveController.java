package com.example.aves.controller;

import com.example.aves.entity.Ave;
import com.example.aves.service.AveService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/aves")
public class AveController {

    private final AveService service;

    public AveController(AveService service) {
        this.service = service;
    }
    private boolean isDebugMode() {
        String debugEnv = System.getenv("AVES_VAR_ENTORNO");
        return debugEnv != null && debugEnv.equalsIgnoreCase("true");
    }
    @GetMapping
    public List<Ave> listar() {
        if (isDebugMode()) {
            System.out.println("Modo debug activado: Listando todas las aves");
        } else {
            System.out.println("Listando todas las aves");
        }
 
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Ave obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Ave crear(@RequestBody Ave ave) {
        return service.guardar(ave);
    }

    @PutMapping("/{id}")
    public Ave actualizar(@PathVariable Long id, @RequestBody Ave ave) {
        return service.actualizar(id, ave);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
