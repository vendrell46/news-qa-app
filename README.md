# Sliide QA Technical Test

## What has been done
### Wrappers
I have started the framework by adding my own wrappers on top of Espresso to ease tests automation
and to make them more readable.

Also, a set of wrappers have been added in utils/Validations.kt in order to handle delays on
instrumented tests while switching activities.

### Tests
Following the scenarios provided I have automated all of them but one, which is meant to be 
executed manually without internet connection. And scenarios 1 and 3 are covered with one test. 
(Please refer to the commit descriptions for more specific information)

### Page Object Pattern
I have followed Page Object Pattern by splitting classes by pages, hence having Elements class for 
elements and a Actions class for both interactions and assertions.



## Bugs
*Device used:* Pixel, 
*OS Version:* 9.0


#### *Title:*
First image in news page gets resized after swiping horizontally

#### *Summary/Description:*
When landing in news screen and swiping left to check the other images in the same carousel
and going back to the first one on the left, it has changed its size.


#### *Steps to recreate:*
1. Log in
2. Swipe left two times
3. Swipe right back to first image


#### *Actual:* 
image has changed size
#### *Expected:* 
image should not change size

#### *Video* 
https://user-images.githubusercontent.com/23363641/130869559-ea0cea15-a3c7-4f46-a449-0e9f284c5df3.mov



__________________________________________________________

#### *Title*
Inconsistency on behaviour when swiping left images

#### *Summary/Description:*
By making the same gesture on screen to swipe left on first row image displayed in News page
it switches to the following image, yet when doing the same gesture to swipe left on the second
row image, it does not stays in the second one but continues to the third available image.


#### *Steps to recreate:*
1. Log in
2. Swipe first row image left once 
3. Swipe second row image left once


#### *Actual:* 
second image gets skipped
#### *Expected:* 
after swiping, second image should be blocked

#### *Video* 
https://user-images.githubusercontent.com/23363641/130869887-cd719b3e-f83f-4377-a8a9-776a1c310fb3.mov



__________________________________________________________

#### *Title*
User gets logged out after hard closing the app

#### *Summary/Description:*
When user logs in to News page and hard closes the app, on relaunch it is not logged in anymore.


#### *Steps to recreate:*
1. Log in
2. hard close the app
3. relaunch


#### *Actual:* 
log in page displayed
#### *Expected:* 
news page should be displayed

#### *Video* 
https://user-images.githubusercontent.com/23363641/130869951-9ebdc31a-69a9-41a7-863d-0c3a0ecc9576.mp4



__________________________________________________________

#### *Title*
User gets logged out soft closing the app when offline

#### *Summary/Description:*
While offline and logged in, soft closing the app logs out user


#### *Steps to recreate:*
1. Log in
2. tap device back button
3. relaunch


#### *Actual:* 
log in page displayed
#### *Expected:* 
news page should be displayed

#### *Video* 
https://user-images.githubusercontent.com/23363641/130870076-d32f2840-1ea6-4348-bcb5-e914a9279507.mp4


## What can be improved
- I have tried to introduce Hilt Android as my Dependency Injection framework but due to dagger's existence in the framework I encountered a lot of
time consuming conflicts and issues on runtime. So, considering the limited time I had for the task I have left it aside as an improvement. An alternative would
be to use Koin as DI framework only for automation.

Some issues with gradle were blocking me to handle interactions with WebView:
 - at first I have tried by adding Intent validations for the url, but unfortunately I have encountered a few issues on runtime that decided to skip
 after a couple of hours of investigation.
 - then I found the possibility to introduce espresso-webview library to interact with *onWebView* but after some attempts to make it work I had to leave 
 leave it aside and continue with the task to not get stuck and lose a lot of time.


## Task

### Description
During the test we want you to imagine yourself as a member of our team, with a collective goal of getting our tasks completed. 

When we have reviewed your test, and any accompanying documents you feel necessary, if we like what we see, we’ll invite you to join us for a video conversation during which we’ll ask you to go through your test, explaining any decisions that you made.

Let’s start!

We are in the middle of the sprint and the following 2 user stories were just moved to the QA testing column on our Jira board:

##
### 1 - As a user I want to log in to the app

#### Scenario 1 - user opens the android app first time (when not logged in yet)

Given - the user opens app for the first time (when not logged in yet)

Then - login screen with user name and password entries and login button is displayed

#### Scenario 2 - user login failed

Given - the user provided wrong user name and/or password

When - login button is clicked

Then - error markers are displayed by user name and/or password entries

#### Scenario 3 - user login succeed (credentials provided below)

Given - the user provided right user name and password

When - login button is clicked

Then - user is taken to the news screen

#### Scenario 4 - user opens app next time (when previously logged in)

Given - the user opens app next time (when previously logged in)

Then - user is taken straight to the news screen

 ##

### 2 - As a user I want to see my news

#### Scenario 1 - news images are loaded

Given - the user successfully logged in to the app

When - there is internet connection

Then - images are displayed in the rows on the list (row can have one or more images scrollable horizontally)

#### Scenario 2 - failed to load images

Given - the user successfully logged in to the app

When - there is no internet connection

Then - “failed to load news” error message is displayed and Retry button

#### Scenario 3 - news image is clicked

Given - the news images are successfully loaded on the screen

When - the user clicks one of the image

Then - user is navigated to the external browser with clicked image loaded

#### Login credentials:
#### user: password
#### password: password

##

Now it’s your turn. You need to verify if we can move these two tickets to Done column on our Jira board.
We expect that these functions will be tested both manually and automatically by you.

### Manual tests - we expect that any bugs will be reported in clear form

### Automated tests - using Espresso or any other tool of your choosing (explain why)

At Sliide we love clean code, so please try to write your tests neatly. 

It’s not mandatory but using an additional abstraction level for your tests (like your own framework to facilitate writing tests) will be very much appreciated

You can access the android project with implemented features below. 


At Sliide we highly appreciate good communication at all times so, if you have any questions, don’t hesitate to ask   

## Good luck!   
