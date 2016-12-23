package com.martin.controller;

import com.martin.entity.Child;
import com.martin.entity.Group;
import com.martin.repository.ChildrenRepository;
import com.martin.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by martin on 23.12.16.
 */
@Controller
@RequestMapping("/gruppe")
public class GroupController {

    private GroupRepository groupRepository;
    private ChildrenRepository childrenRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository, ChildrenRepository childrenRepository){
        this.groupRepository = groupRepository;
        this.childrenRepository = childrenRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listGroups(Model model){
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups",groups);
        return "groupList";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGroup (){
        return "groupCreation";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createGroup(@RequestParam String name){
        Group group = new Group(name);
        groupRepository.save(group);
        return "redirect:/gruppe";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detailGroup(@PathVariable int id, Model model){
        Group group = groupRepository.findOne(id);
        List<Child> children = childrenRepository.findByGroup_Id(id);
        model.addAttribute("group",group);
        model.addAttribute("children",children);
        return "groupDetail";
    }

}
