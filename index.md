### 1. Project Description

I intend on creating a website that helps the "Out of the Shell" club plan events and allows memebers to post information about themselves.  The purpose of the club is to help people make new friends by introducing them to other students who are struggling in finding a social circle.  The main functionality of the website would allow for members to create profiles that are accessible to other club members.  The profiles should include intrests, bios, fun facts, or anything that will allow  Additionally, a posting board that allows members to announce social gatherings would improve organization.

### 2. Project Design - lower-level description. What technologies will you use, how will they integrate? The technologies that this project will utilize will be SpringMVC/SpringBoot, Slack API, MongoDB, TomcatApache. This is list is incomplete and there will be other technologies. What are the project’s use cases? Any other design docs that are necessary for me to understand your project

Project Features
1) Create a splash page that communicates the goals of our club and that welcomes new users.
2) Have the ability to create a new profile and populate it with relevant fields, such as interests, hobbies, or a biography.
3) Provide the ability to add an image to the profile.
4) Provide the ability to edit the profile.
5) Display a list of members with a hyperlink to their profile.
6) Have a club chat that is integrated into the web application, which will allow for people to organize outings outside the group context.

Like the rest of the class, I will be utilizing SpringMVC, SpringBoot, Slack API, and MongoDB.  However I decided that I would utilize GlassFish instead of Tomcat.  This was because GlassFish has additional features beyond simply being an HTTP server.  After doing some extra research, I feel that the documentation surrounding GlassFish for building basic chat applicaitons is far more extensive.  Additionally, NetBeans has built in functionality that allows for projects to easily be created using GlassFish.

For the built in chat application for the website, I'll likely use jQuery and Ajax.  In addition, I intend on using a technique called long polling for the chat.  This is simple to implement, and far more scalable than normal polling for chat applications.  

### 3. Project Schedule - what will you have done at each checkpoint? What will the final project look like?

Checkpoint 1
1) Create a splash page that communicates the goals of our club and that welcomes new users.
2) Have the ability to create a new profile and populate it with relevant fields, such as interests, hobbies, or a biography.
3) Create the overall skeleton of the website

Checkpoint 2
1) Provide the ability to add an image to the profile.
2) Provide the ability to edit the profile.
3) Display a list of members with a hyperlink to their profile.

Checkpoint 3
1) Have a club chat that is integrated into the web application, which will allow for people to organize outings outside the group context.

### 4. Project Justification - why is your project interesting? Novelty - why is your project different than existing applications, and why should people use it?

The turn over rate in the club is extremely high, which is actually what we want, since that means that club members are finding social circles that work for them.  However, there are instances in which new members come in that could integrate well with previous members that left.  Having a posting board with profiles would allow for old members to better stay in touch.  We could use Facebook for this purpose, but members typically don’t want to broadcast that they’re having difficulty finding friends.  Therefore, a separate and more discrete platform is ideal.

Right now, we only have a GroupMe, which introduces several issues.  Most old will leave the GroupMe to avoid getting club messages once they found a steady group of friends.  By using an external application, it assures that they will only receive messages that are pertinent to them, either via email or texting.  This will increase the likelihood that they stay involved with the club.  Furthermore, time could be saved on introductions by having all the basic information about club members displayed on the club’s web application.
