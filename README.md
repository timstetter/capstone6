# capstone6
Spring MVC Task Demo

WEEK 6 CAPSTONE: TASK LIST REVISITED

Intro: Several months into your first developer position, Jill the project manager comes
back to you. “Remember that task list we had you start as a console app a while back?
We’ve finally decided--we want it as a web app. Think you can dust it off and make it for
us? This time we only want users to see their own tasks, but it should basically work the
same as the console app.”

Task: Create a web-based task manager

What Will the Application Do?

● A user can create a new account with email address and password

● Once logged in, the user can create a new task. Tasks consist of:

  o The ID of the user who owns it (user doesn’t get to edit this field)
  o A task description
  o The due date
  o Whether it’s complete or not
  
● The user should see a list of all tasks they own

  o There should be a button or checkbox to mark the task complete
  o There should be a button to delete the task
  
Build Specifications

  1. Build this as a Spring MVC web application
  2. Store users and tasks in separate database tables
  3. Minimum views: Welcome/login page, task list, add task view
  
Hints

  ● Show only the tasks which have this user’s ID
  
Extended Challenges

● Let the user search for a task by a word or words in the description
● Let the user sort or filter by due date
● Let the user sort or filter by completion status
