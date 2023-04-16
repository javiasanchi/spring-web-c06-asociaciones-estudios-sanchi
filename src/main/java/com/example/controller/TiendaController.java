package com.example.controller;

import com.example.entities.Mercado;
import com.example.entities.Tienda;
import com.example.services.MercadoService;
import com.example.services.TiendaService;
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
public class TiendaController {
    private final MercadoService mercadoService;
    private TiendaService tiendaServ;

    @GetMapping("main/tienda/list-tienda")
    public String findAll (Model model){
        List<Mercado> tiendas = mercadoService.findAll();
        model.addAttribute("mensaje","Listado de tiendas de mercados de ");
        model.addAttribute("tiendas", tiendas);

        return "/tienda/list-tiendas";
    }
    @GetMapping("main/tienda/list-tienda/{id}")
    public String findById (Model model, @PathVariable Long id){
        Optional<Tienda> tiendaOp = tiendaServ.findById(id);
        if (tiendaOp.isPresent())
            model.addAttribute("tienda", tiendaOp.get());

        else
            model.addAttribute("error","TIENDA NO EXISTE O NO SE ENCUENTRA");
                return "/tienda/info-tienda";
        }
        /*@GetMapping("main/ciudad/{ciudad}")
    public String findByCiudad (Model model, @PathVariable String ciudad) {
        model.addAttribute("mercado" , mercadoService.findAllByCiudad(ciudad));
        return "main";
        }*/
        @GetMapping("main/crear")
    public String crear (Model model){
        model.addAttribute("tienda", new Tienda());
        return "/tienda/form-tienda";
        }
    @GetMapping("main/{id}/tienda/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Tienda> tiendaOp = tiendaServ.findById(id);
        if (tiendaOp.isPresent())
            model.addAttribute("tienda", tiendaOp.get());
        else
            model.addAttribute("error", "MERCADO NO EXISTE O NO SE ENCUENTRA");

        return "form-tienda";
    }

    @PostMapping("main/tienda") // POST http://localhost:8080/foods
    public String saveForm(@ModelAttribute Tienda tienda) {
        tiendaServ.save(tienda);
        return "redirect:/main"; // Redirección a GET /foods
    }

    @GetMapping("main/tienda/{id}/borrar")
    public String deleteById(@PathVariable Long id) {
        tiendaServ.deleteById(id);
        return "redirect:/main";
    }

}



