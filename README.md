# UTIL CRUNCHER
# PROJECT MADE BY 
RAGHAV BOBAL (C0780996)
# PROJECT DESCRIPTION
An application that calculates the total bills for a customer. A bill could be an internet bill, a hydro bill,a bill for mobile usage or can be an insurance bill. A customer may or may not have multiple bills.

Edit launchScreen, implement proper login/logout, display a list of customers, add new customers, data access and storage with singleton class, validations, display errors and alerts, display basic customer information.
Display bills of the respective customers, adding a button to add new bills for each respective customer and adding adding three new respective view controllers and designed it accordingly.
# PROJECT STRUCTURE

<img src="https://i93.servimg.com/u/f93/18/45/29/87/classt10.png" alt="Class Structure" style="float: left; margin-right: 10px;"/>
<img src="https://i93.servimg.com/u/f93/18/45/29/87/classt11.png" alt="Class Structure" style="float: center; margin-right: 50px;"/>


## PROJECT OUTPUT
Screenshot | Description
--- | ---
<img src="https://i.ibb.co/XbqKV5Y/splashscreen.png"/> | Splash screen that lasts 5 seconds.
<img src="https://i.ibb.co/ckNr07L/Screenshot-1586486388.png"> | Data entry screen for the app.Used Text Watch that checks each field to see if it is empty,checks the age and SIN Number format. Date of filing is set to currentdate and it cannot be changed. Trying to change the date of filing field will give the user a warning message.
<img src="https://i.ibb.co/7SJp9HX/Screenshot-1586486513.png"/> | Activity to display all the details of the person as well as the calculated details.
<img src="https://i.ibb.co/VxZdzYK/Screenshot-1586486470.png"/> | Error that appears when the age is less than 18 years old.
<img src="https://i.ibb.co/K0HztHZ/Screenshot-1586486904.png"/> | Validations for SIN number using regex, age and text watcher.
<img src="https://i.ibb.co/gzjdH3L/Screenshot-1586486930.png"/> | Error if the gross income is left empty or is invalid.
<img src="https://i.ibb.co/2KbBPGF/Screenshot-1586486941.png"/> | Error if the RRSP is left empty or is invalid.


# REFERENCES
* [Youtube.com](https://www.youtube.com/watch?v=VDZas1ax_Xo) - Helped with text watcher.
* [Android.jlelse.eu](https://android.jlelse.eu/the-complete-android-splash-screen-guide-c7db82bce565) - Creating a splashscreen.
* [Youtube.com](https://www.youtube.com/watch?v=A9rcKZUm0zM&t=287s) -  Used for removing Action Bars.
* [Joda.org](https://www.joda.org/joda-time/index.html) - Working with Joda-Time.
* [Youtube.com](https://www.youtube.com/watch?v=09EsYJrhBYE&t=356s) - Used for text inout layout.
* [Stackoverflow.com](https://stackoverflow.com/questions/11253512/change-on-color-of-a-switch) - For switch colors
* [Sitepoint.com](https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/) - Data transfer between activities using parcelable.
* [Journaldev.com](https://www.journaldev.com/14748/android-textinputlayout-example) - Working with textfields using Material Design.
* [Youtube.com](https://www.youtube.com/watch?v=aS__9RbCyHg) - Helped with pretty much everything.
