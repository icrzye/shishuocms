package com.shishuo.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shishuo.cms.constant.ConfigConstant;
import com.shishuo.cms.entity.Folder;
import com.shishuo.cms.entity.vo.FileVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderAction {

	@Autowired
	private FolderService folderService;

	@RequestMapping(value = "{folderId}", method = RequestMethod.GET)
	public String folder(@PathVariable long folderId,
			@RequestParam(value = "pageNum", defaultValue = "1") long pageNum,
			ModelMap modelMap) {
		modelMap.addAttribute("pageNum", pageNum);
		Folder currentFolder =  folderService.getFolderById(folderId);
		modelMap.addAttribute("currentFolder", currentFolder);
		return ConfigConstant.getTemplatePath() + "/"+currentFolder.getTemplate();
	}
	
}
