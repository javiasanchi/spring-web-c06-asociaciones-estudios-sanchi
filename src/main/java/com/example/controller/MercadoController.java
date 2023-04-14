package com.example.controller;

import com.example.entities.Mercado;
import com.example.services.MercadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class MercadoController {
    private final MercadoService mercadoService;

    @GetMapping("main")
    public String findAll (Model model){
        List<Mercado> mercados = mercadoService.findAll();
        model.addAttribute("mensaje","Listado de mercados de Alcorcón");
        model.addAttribute("mercados", mercados);

        return "main";
    }
    @GetMapping("main/{id}")
    public String findById (Model model, @PathVariable Long id){
        Optional<Mercado> mercaOpt = mercadoService.findById(id);
        if (mercaOpt.isPresent())
            model.addAttribute("mercado", mercaOpt.get());

        else
            model.addAttribute("error","MERCADO NO EXISTE O NO SE ENCUENTRA");
                return "info";
        }
        @GetMapping("main/ciudad/{ciudad}")
    public String findByCiudad (Model model, @PathVariable String ciudad) {
        model.addAttribute("mercado" , mercadoService.findAllByCiudad(ciudad));
        return "main";
        }
        @GetMapping("main/crear")
    public String crear (Model model){
        model.addAttribute("mercado", new Mercado());
        return "formulario";
        }
    @GetMapping("main/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Mercado> mercadoOp = mercadoService.findById(id);
        if (mercadoOp.isPresent())
            model.addAttribute("mercado", mercadoOp.get());
        else
            model.addAttribute("error", "MERCADO NO EXISTE O NO SE ENCUENTRA");

        return "formulario";
    }

    @PostMapping("main") // POST http://localhost:8080/foods
    public String saveForm(@ModelAttribute Mercado mercado) {
        mercadoService.save(mercado);
        return "redirect:/main"; // Redirección a GET /foods
    }

    @GetMapping("main/{id}/borrar")
    public String deleteById(@PathVariable Long id) {
        mercadoService.deleteById(id);
        return "redirect:/main";
    }

}



