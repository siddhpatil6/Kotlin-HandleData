# Kotlin-HandleData
# How to Handle Data when screen rotates?

There are three ways you can do it
1. If Your app is based on one orientation than mention that in manifest file with activity attributes
`<activity android:name=".HandleDataActivity"`
            `android:screenOrientation="portrait">` // or landscape
            
# Prevent Activity to recreated

2. If Apps are working on both the orientations, one way is that you can make changes in Android Manifest file to maintain the data with activity attribute.
   `<activity android:name=".HandleDataActivity"`
            `android:configChanges="orientation|screenSize">`

3. It can be done by coding using two methods which are used in activity life cycle when screen rotates
* onSaveInstanceState
* onRestoreInstanceState


# Save basic state
### On Saved instance state method, here we saved data before destroy method get called
 This is the most common situation to save the basic data of your Activity or Fragment during orientation change. You can save Primitive data such as String, Boolean, Integers or Parcelable objects in a Bundle during the orientation change and read the same data when Activity recreated.

Saving and restoring the data works using two Activity lifecycle methods called onSaveInstanceState() and onRestoreInstanceState().

To save the state information override onSaveInstanceState() method and add key-value pairs to the Bundle object that is saved in the event that your activity is destroyed unexpectedly. This method gets called before onStop().




`override fun onSaveInstanceState(outState: Bundle?) `

`{`

        `super.onSaveInstanceState(outState)`

        `Toast.makeText(this,"onSaveInstanceState Method Called",Toast.LENGTH_LONG).show()`

        `outState?.putString("name",""+etName?.text.toString()+" "+etMiddleName?.text.toString()+" "+etLastName?.text.toString())`


`}`


### on restore instance state method, it retrieves data from the bundle

To recover your saved state from the Bundle override onRestoreInstanceState() method. This is called after onStart() and before onResume().

`override fun onRestoreInstanceState(savedInstanceState: Bundle?) `
`{`
       
       `super.onRestoreInstanceState(savedInstanceState)`
        
        `Toast.makeText(this,"onRestoreInstanceState Method Called",Toast.LENGTH_LONG).show()`
       
       `setName(savedInstanceState?.getString("name","").toString())`

`}`
