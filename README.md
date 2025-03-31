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


## Analysis

### Scenario
The FHNW Chess Club web application is a dedicated platform for chess enthusiasts within the FHNW community. It is designed to connect students and faculty members who share a passion for chess, providing a structured and competitive environment to practice, compete, and track their progress.
With an intuitive and user-friendly interface, the platform allows users to register, manage their profiles, participate in tournaments, track leaderboard rankings, and challenge other players. Whether you're a casual player looking for friendly matches or a serious competitor aiming for the top of the leaderboard, this app offers all the necessary features to enhance your chess skills.

### User Stories
1. As an Admin, I want a web app that works on both mobile devices and desktop computers so that I can manage the chess platform from any device.
2. As an Admin, I want a visually consistent interface so that I can navigate and manage the system efficiently.
3. As an Admin, I want to use list views to explore and manage users, tournaments, and leaderboard rankings.
4. As an Admin, I want to create, update, and delete tournament data so that I can manage chess competitions. ++++
5. As an Admin, I want to log in so that I can securely access administrative features.
6. As an Admin, I want to manage user accounts so that I can enforce fair play and moderation. ++++
#
7. As a User, I want to authenticate myself so that I can track my personal stats and history.
8. As a User, I want to view the list of upcoming tournaments so that I can find and participate in competitions. ++++
9. As a User, I want to register for a tournament so that I can compete in chess matches. ++++
10. As a User, I want to see my tournament history and match results so that I can track my performance. ++++
11. As a User, I want to challenge another player to a chess match so that I can improve my ranking. ++++
12. As a User, I want to view the leaderboard so that I can compare my ranking with other players. ++++

### Use Case
- UC-1 [View All Tournaments]: Admin and users can retrieve a list of all available tournaments.
- UC-2 [View Tournament Details]: Admin or users can retrieve information about a specific tournament (e.g., participants, rules, schedule).
- UC-3 [Manage Tournaments]: Admin can create, update, and delete tournaments. 
- UC-4 [View Leaderboard]: Users can view ranking and player performance statistics. ++++
- UC-5 [Log in]: Admin and registered users can authenticate to access personalized features.
- UC-6 [Enroll in a Tournament]: Users can register for a chess tournament. ++++
- UC-7 [Challenge a Player]: Users can send and accept match invitations. ++++
  

## Design

### Wireframe
By the beginning of the project, we already had the idea and the prototype, so we didn't need to go through the wireframing phase.

### Prototype
![1](https://github.com/user-attachments/assets/b37bd075-5466-42b1-92b7-e4619d0cd4dd)

![2](https://github.com/user-attachments/assets/0262f6c2-2b00-437e-a3c0-1e0d47bc942b)

![3](https://github.com/user-attachments/assets/2726db40-5f2f-4a06-861c-1667c859f47e)

![4](https://github.com/user-attachments/assets/ee8ab9b1-6bd1-49fd-b3d2-35e9948ff1d6)

![5](https://github.com/user-attachments/assets/c66682e3-5ae6-4326-8ab1-8d7094e0d354)

![6](https://github.com/user-attachments/assets/bb959b5c-73eb-4998-bcac-bc544a000f06)

![7](https://github.com/user-attachments/assets/ab871b53-695b-463f-a7f7-29f15b3c4eb7)

### Domain Design
UML class diagram

![UML   ](https://github.com/user-attachments/assets/8865cbd7-e5f3-41d0-875e-12799ea353fd)

### CLASSES
1 User (player/admin). Admin inherits attributes from User but has Admin-specific methods that the Player doesn't have.
2 Profile (user profile)
3 Enrollment (enrollment into a tournament)
4 Challenge (challenging another player to a chess match)
5 Leaderboard (of the tournament)
6 Match (a play between 2 users)
7 Tournament (chess tournament)

### CARDINALITY
One user can have one profile.
One user can enroll into multiple matches.
One user can participate send/receive multiple challenges.
One tournament can contain multiple enrollments and matches.

### RELATIONSHIPS
Admin is a subclass of User and inherits attributes from User. However, it also has it's own methods.
If the user is deleted, the profile is deleted too, therefore relationship between user and profile is composition.
The same goes to tournament and enrollments where one doesn't make sense (wouldn't exist) without the other.
Other relations: association (a structural connection).








