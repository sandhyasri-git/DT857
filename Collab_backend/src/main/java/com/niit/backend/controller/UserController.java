package com.niit.backend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.UserDetails;

@RestController
@EnableWebMvc
public class UserController {
	
	@Autowired
	HttpSession httpSession;

	@Autowired
	UserDetails user;

	/*@Autowired
	FriendDAO friendDAO;
*/
	@Autowired
	UserDAO userDAO;

	/* http://localhost:8091/Collab_backend/userL----userList */
	@RequestMapping("/users/")
	public ResponseEntity<List<UserDetails>> getAllUser() {
		List<UserDetails> users = userDAO.list();

		if (users.isEmpty()) {
			user.setErrorCode("404");
			user.setErrorMessage("No users are available");
			System.out.println("user list ...");
			// adding this msg
			users.add(user);
		}
		return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
	}

	/* http://localhost:8091/Collab_backend/userL/uid---to get particular user */

	@RequestMapping("/users/{uid}")
	public ResponseEntity<UserDetails> getByUserId(@PathVariable("uid") String userId) {
		user = userDAO.get(userId);
		if (user == null) {
			user = new UserDetails();// to avoid NLP-EX
			user.setErrorCode("404");
			user.setErrorMessage("User does not exist with id " + userId);

			System.out.println("get user by id  ...");
		}
		user.setErrorCode("200");
		user.setErrorMessage("User exists with id " + userId);

		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* http://localhost:8091/Collab_backend/userL/uid/password---authenticate user */

	@RequestMapping(value = "/authenticate/", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> autheticate(@RequestBody UserDetails user, HttpSession session) {
		user = userDAO.isValidUser(user.getEmail_id(), user.getPassword());
		if (user == null) // if the credentials r wrong
		{
			user = new UserDetails(); // to avoid NLP-EX
			user.setErrorCode("404");
			user.setErrorMessage("invalid credentials.. pls try again!!");

			System.out.println("authenticate  false...");

		} else // valid credentials
		{

			user.setErrorCode("200");
			user.setErrorMessage("successfully logged in...");

			user.setIsonline('Y');
			/*session.setAttribute("loggedInUser", user);
*/
			session.setAttribute("loggedInUserID", user.getUser_id());
			
			session.setAttribute("loggedInUserRole", user.getRole());
			
			/*friendDAO.setOnline(user.getUserid());
*/			userDAO.setOnline(user.getUser_id());
			System.out.println("authenticate  ...in user controller.java");
			// store the id in session
			// httpSession.setAttribute("loggedInUserId",user.getUserid());
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> register(@RequestBody UserDetails user) {
		
		if (userDAO.get(user.getUser_id()) == null) {

			user.setIsonline('N');
			user.setStatus("N");
			if (userDAO.save(user) == true) {
				user.setErrorCode("200");
				user.setErrorMessage(
						"Thank you for registration.You have successfully registered as " + user.getRole());

				System.out.println("register  ...in user controller.java..");
			} else {
				user.setErrorCode("404");
				user.setErrorMessage("Could not complete the operatin please contact Admin");
			}
			return new ResponseEntity<UserDetails>(user, HttpStatus.OK);

		}
		user.setErrorCode("404");
		user.setErrorMessage("User already exist with id : " + user.getUser_id());
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);

	}
	/* Update */
	@RequestMapping(value = "/update/", method = RequestMethod.PUT)
	public ResponseEntity<UserDetails> update(@RequestBody UserDetails user) {
		if (userDAO.get(user.getUser_id()) == null) {
			user.setErrorCode("404");
			user.setErrorMessage("Update is not successfull..");

		} else {
			userDAO.update(user);
			user.setErrorCode("200");
			user.setErrorMessage("Successfully updated......");
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* makeAdmin */
	@RequestMapping(value = "/makeAdmin/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDetails> makeAdmin(@PathVariable("id") String userId) {

		user = userDAO.get(userId);

		if (user == null) {
			user = new UserDetails();
			user.setErrorCode("404");
			user.setErrorMessage("Employee does not exists..");
			return new ResponseEntity<UserDetails>(user, HttpStatus.OK);

		}
		if (user.getRole() != "Employee") {
			user = new UserDetails();
			user.setErrorCode("404");
		user.setErrorMessage("This user cannot be  admin.." + userId);
			return new ResponseEntity<UserDetails>(user, HttpStatus.OK);

		}
		user.setRole("Admin");
		userDAO.update(user);
		user.setErrorCode("200");
		user.setErrorMessage("Employee role updated as admin successfully:" + user.getUser_name() + " " + userId);

		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* Accept/uid */
	@RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> accept(@PathVariable("id") String id) {

		user = updateStatus(id, "Accept", "");
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* Reject */
	@RequestMapping(value = "/reject/{id}/{reasonn}", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> reject(@PathVariable("id") String id, @PathVariable("reasonn") String reason) {

		user = updateStatus(id, "Reject", reason);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* this mthd is used in accept and reject */
	private UserDetails updateStatus(String id, String status, String reason) {

		user = userDAO.get(id);
		if (user == null) {
			user = new UserDetails();
			user.setErrorCode("404");
			user.setErrorMessage("could not update the status to :" + status);

		} else {
			user.setStatus(status);
			user.setReason(reason);
			userDAO.update(user);
			user.setErrorCode("200");
			user.setErrorMessage("status is updated successfully..");

		}
		return user;
	}
	/* ........................................ */

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)

	public ResponseEntity<UserDetails> logout(HttpSession session) {

		String loggedInUserID = (String) session.getAttribute("loggedInUserID");

		/*friendDAO.setOffline(loggedInUserID);*/

		//userDAO.setOffline(loggedInUserID);

		session.invalidate();

		user.setErrorCode("200");

		user.setErrorMessage("You have successfully logged");

		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	/* ///////////////////////////////// */

	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)

	public ResponseEntity<UserDetails> myProfile(HttpSession session) {
		System.out.println("->->calling method myProfile");
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		UserDetails user = userDAO.get(loggedInUserID);
		if (user == null) {
			System.out.println("->->->-> User does not exist wiht id" + loggedInUserID);
			user = new UserDetails(); // It does not mean that we are inserting new
								// user
			user.setErrorCode("404");
			user.setErrorMessage("User does not exist");
			return new ResponseEntity<UserDetails>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
}
