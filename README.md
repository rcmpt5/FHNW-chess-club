# FHNW Chess Club

#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic](#business-logic)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)


### Scenario

The FHNW Chess Club web application is a dedicated platform for chess enthusiasts within the FHNW community. It is designed to connect students and faculty members who share a passion for chess, providing a structured and competitive environment to practice, compete, and track their progress.
With an intuitive and user-friendly interface, the platform allows users to register, manage their profiles, participate in tournaments, track leaderboard rankings, and challenge other players. Whether you're a casual player looking for friendly matches or a serious competitor aiming for the top of the leaderboard, this app offers all the necessary features to enhance your chess skills.
 

### User Stories
1. As an Admin, I want a web app that works on both mobile devices and desktop computers so that I can manage the chess platform from any device.
2. As an Admin, I want a visually consistent interface so that I can navigate and manage the system efficiently.
3. As an Admin, I want to use list views to explore and manage users, tournaments, and leaderboard rankings.
4. As an Admin, I want to create, update, and delete tournament data so that I can manage chess competitions.
5. As an Admin, I want to log in so that I can securely access administrative features.
6. As an Admin, I want to manage user accounts so that I can enforce fair play and moderation.

7. As a User, I want to authenticate myself so that I can track my personal stats and history.
8. As a User, I want to view the list of upcoming tournaments so that I can find and participate in competitions.
9. As a User, I want to register for a tournament so that I can compete in chess matches.
10. As a User, I want to see my tournament history and match results so that I can track my performance.
11. As a User, I want to challenge another player to a chess match so that I can improve my ranking.
12. As a User, I want to view the leaderboard so that I can compare my ranking with other players.


### Use Case

![](images/use-case.png)

- UC-1 [View All Tournaments]: Admin and users can retrieve a list of all available tournaments.
- UC-2 [View Tournament Details]: Admin or users can retrieve information about a specific tournament (e.g., participants, rules, schedule).
- UC-3 [Manage Tournaments]: Admin can create, update, and delete tournaments.
- UC-4 [View Leaderboard]: Users can view ranking and player performance statistics.
- UC-5 [Log in]: Admin and registered users can authenticate to access personalized features.
- UC-6 [Enroll in a Tournament]: Users can register for a chess tournament.
- UC-7 [Challenge a Player]: Users can send and accept match invitations.
  

## Design

### Wireframe
> 🚧: It is suggested to start with a wireframe. The wireframe focuses on the website structure (Sitemap planning), sketching the pages using Wireframe components (e.g., header, menu, footer) and UX. You can create a wireframe already with draw.io or similar tools. 

Starting from the home page, we can visit different pages. Available public pages are visible in the menu...

### Prototype
![1](https://github.com/user-attachments/assets/d69a3781-99c7-4933-9d73-c51020e9b73d)

![2](https://github.com/user-attachments/assets/159e98e2-2dc3-4f42-9e17-9056fa764502)

![3](https://github.com/user-attachments/assets/2c9f74aa-7494-4b4d-a369-7bcdccfd25a9)

![4](https://github.com/user-attachments/assets/946635cc-ab12-4799-9885-b00dad017f3e)

![5](https://github.com/user-attachments/assets/98eb6a83-68a2-4b82-9158-ddd2ece59e01)

![6](https://github.com/user-attachments/assets/8178907f-921d-4843-857c-4f463fdc1d97)

![7](https://github.com/user-attachments/assets/4b62ffed-b549-4a73-97f9-4a93b4dcebc1)

![9](https://github.com/user-attachments/assets/37bd08ef-8d38-4356-be29-d585ab81012e) 

### Domain Design
> 🚧: Provide a picture and describe your domain model; you may use Entity-Relationship Model or UML class diagram. Both can be created in Visual Paradigm - we have an academic license for it.

The `ch.fhnw.pizza.data.domain` package contains the following domain objects / entities including getters and setters:

![](images/domain-model.png)


