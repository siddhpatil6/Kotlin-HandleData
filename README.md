# Kotlin-HandleData
# How to Handle Data when screen rotates?

There are three ways you can do it
1. If Your apps is based on one orientation than mention that in manifest file with activity attributes
`<activity android:name=".HandleDataActivity"`
            `android:screenOrientation="portrait">` // or landscape

2. If Apps are working on both the orientations, one way is that you can make changes in Android Manifest file to maintain the data with activity attribute.
   `<activity android:name=".HandleDataActivity"`
            `android:configChanges="orientation|screenSize">`

3. It can be done by coding using two methods which are used in activity cycle when screen rotates
* onSaveInstanceState
* onRestoreInstanceState

### On Saved instance state method, here we saved data before destroy method get called
 
`override fun onSaveInstanceState(outState: Bundle?) `

`{`

        `super.onSaveInstanceState(outState)`

        `Toast.makeText(this,"onSaveInstanceState Method Called",Toast.LENGTH_LONG).show()`

        `outState?.putString("name",""+etName?.text.toString()+" "+etMiddleName?.text.toString()+" "+etLastName?.text.toString())`


`}`


### on restore instance state method, it retrieves data from the bundle

`override fun onSaveInstanceState(outState: Bundle?) `

`{`

        `super.onSaveInstanceState(outState)`

        `Toast.makeText(this,"onSaveInstanceState Method Called",Toast.LENGTH_LONG).show()`
        `outState?.putString("name",""+etName?.text.toString()+" "+etMiddleName?.text.toString()+" "+etLastName?.text.toString())`

`}`
