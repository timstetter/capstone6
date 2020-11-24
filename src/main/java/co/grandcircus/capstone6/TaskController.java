package co.grandcircus.capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private TaskRepository taskRep;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(User user, Model model) {
		User newUser = userRep.findByEmail(user.getEmail()); 
		if (newUser != null && newUser.getPassword().compareTo(user.getPassword()) == 0) {
			session.setAttribute("email", newUser.getEmail());
			session.setAttribute("userid", newUser.getId());
			return "redirect:/tasks";
		}
		else {
			model.addAttribute("error", "Error. Please try again.");
			return "index";
		}
	}
	
	@GetMapping("/logout")
	public String logout( ) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String register(User user, Model model) {
		User newUser = userRep.findByEmail(user.getEmail());
		if (newUser != null) {
			model.addAttribute("error", "Already exists");
			return "index";
		} 
		userRep.save(user);
		session.setAttribute("email", user.getEmail());
		session.setAttribute("userid", user.getId());
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks")
	public String tasks(Model model) {
		String email = (String) session.getAttribute("email");
		User user = userRep.findByEmail(email);
		model.addAttribute("user", user);
		return "tasks";
	}
	
	@PostMapping("/addtask")
	public String save(Task task, Model model) {
		String email = (String)session.getAttribute("email");
		if (email == null) {
			return "redirect:/";
		}
		User newUser = userRep.findByEmail(email);
		task.setUser(newUser);
		taskRep.save(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/completed")
	public String completed(Long id) {		
		long userid = (long)session.getAttribute("userid");
		
		Task task = taskRep.findById(id).orElse(null);
		
		if (task == null || task.getUser().getId() != userid) {
			
			return "redirect:/tasks";
		}
		
		task.setComplete(true);
		
		taskRep.save(task);
		
		return "redirect:/tasks";
	}
	
	@GetMapping("/remove")
	public String deletetask(Long id) {		
		long userid = (long)session.getAttribute("userid");
		
		Task task = taskRep.findById(id).orElse(null);
		
		if (task == null || task.getUser().getId() != userid) {
			return "redirect:/tasks";
		}
		
		taskRep.delete(task);
		
		return "redirect:/tasks";
	}
	
	
	
}
