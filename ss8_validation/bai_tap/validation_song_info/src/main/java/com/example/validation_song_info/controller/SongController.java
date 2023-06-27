package com.example.validation_song_info.controller;

import com.example.validation_song_info.dto.SongDto;
import com.example.validation_song_info.model.Song;
import com.example.validation_song_info.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("songs")
@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("songList", songService.display());
        return "home";
    }

    @GetMapping("/create-form")
    public String createSong(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create1")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            Song songEntity = new Song();
            BeanUtils.copyProperties(songDto, songEntity);
            songService.createSong(songEntity);
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công!");
            return "redirect:/songs";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) != null) {
            songService.deleteSong(id);
            redirectAttributes.addFlashAttribute("msg", "xóa thành công");
            return "redirect:/songs";
        } else {
            redirectAttributes.addFlashAttribute("msg", "xóa không thành công");
            return "redirect:/songs";
        }
    }

    @GetMapping("update/{id}")
    public String updateCreate(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) != null) {
            model.addAttribute("songDto", songService.findById(id));
            return "update";
        } else {
            redirectAttributes.addFlashAttribute("msg", "cập nhập không thành công");
            return "redirect:/songs";
        }
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "cập nhật thất bại");
            return "/update";
        }
        if (songService.findById(songDto.getId()) != null) {
            Song songEntity = new Song();
            BeanUtils.copyProperties(songDto, songEntity);
            songService.editSong(songEntity);
            redirectAttributes.addFlashAttribute("msg", "cập nhật thành công");
            return "redirect:/songs";
        }
        else {
            redirectAttributes.addFlashAttribute("msg", "cập nhật thất bại");
            return "/update";
        }

    }
}
