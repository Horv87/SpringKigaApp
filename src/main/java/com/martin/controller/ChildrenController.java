package com.martin.controller;

import com.martin.entity.Child;
import com.martin.entity.Group;
import com.martin.repository.ChildrenRepository;
import com.martin.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martin on 23.12.16.
 */
@Controller
@RequestMapping("/kinder")
public class ChildrenController {
    private ChildrenRepository childrenRepository;
    private GroupRepository groupRepository;

    @Autowired
    public ChildrenController(ChildrenRepository childrenRepository, GroupRepository groupRepository) {
        this.childrenRepository = childrenRepository;
        this.groupRepository = groupRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
     public String listChildren(Model model) {
        List<Child> children = childrenRepository.findAll();
        model.addAttribute("children",children);
        return "childrenList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createChildren(){

        return "childCreation";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createChild(@RequestParam String name, @RequestParam int age){
        Child child = new Child(name,age);
        childrenRepository.save(child);
        return "redirect:/kinder";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String detailChild(@PathVariable int id, Model model){
        Child child = childrenRepository.findOne(id);
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("child",child);
        model.addAttribute("groups",groups);
        return "childDetail";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detailChild(@PathVariable int id,@RequestParam int groupId){
        Child child = childrenRepository.findOne(id);
        Group group = groupRepository.findOne(groupId);
        child.setGroup(group);
        childrenRepository.save(child);
        return "redirect:/kinder";
    }

}
