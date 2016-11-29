package hxk.action;

import java.util.HashMap;
import java.util.Map;

import hxk.model.Student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @description 关于Restful的定义
	GET /user/10086  查询10086用户资料。
 	POST /user  用户注册。 
	PUT /user/10086  修改10086用户资料。 
	DELETE /user/10086  删除10086用户
	用同一个 URL，不同的动词 做不同的操作
 *2015-4-11  上午10:32:12
 */
@Controller
@RequestMapping("/student/")
public class StudentAction {
    @RequestMapping(value = "{name}",method=RequestMethod.GET)
    public @ResponseBody Student get(@PathVariable String name,HttpServletRequest request){
	System.out.println("这是获取Student的方法请求 : " + name);
	//模拟数据库获取值
	return Student.getStudent(name);
    }
    
    @RequestMapping(value = "{name}",method=RequestMethod.PUT)
    public @ResponseBody Student update(@PathVariable String name,HttpServletRequest request){
	System.out.println("这是更新Student的方法请求 : " + name );
	Student student = Student.getStudent(name);
	student.setAge(26);
	return student;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Student add(Student student,HttpServletRequest request){
	System.out.println("这是添加Student的方法请求");
	//模拟数据库添加值
	return student;
    }
    
    @RequestMapping(value = "{name}",method=RequestMethod.DELETE)
    public @ResponseBody Map<String, Integer> delete(@PathVariable String name,HttpServletRequest request){
	Student student = Student.getStudent(name);
	System.out.println("这是删除Student的方法请求 : " + student.getName());
	student = null;
	//话说这里就想简单的传个json模样的字符串..在不使用JSONObject的情况下怎么简单的传过去啊..
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("ok", 1);
	return map;
    }
    
    @RequestMapping(value="/findUser")
    public String findUser(String name){
    	System.out.println(name);
    	return name;
    }
    	
}
