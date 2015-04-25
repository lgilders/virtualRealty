<?php
/* Set e-mail recipient */
$myemail = "virtualrealtyllc@gmail.com";
$header = "From: $myemail \r\n";

/* Check all form inputs using check_input function */
$firstName = check_input($_POST['firstName'], "Your First Name");
$lastName = check_input($_POST['lastName'], "Your Last Name");
$email = check_input($_POST['contactEmail'], "Your E-mail Address");
$phone = check_input($_POST['phoneNumber'], "Your Phone Number");
$billingAddress = check_input($_POST['billingAddress'], "Your Billing Address");
$scanPackage = $_POST['scanPackage'];
$hostingPackage = $_POST['hostingPackage'];
$scanAddress = check_input($_POST['scanAddress'], "Your Scan Address");
$specialInstructions = check_input($_POST['specialInstructions'], "Your Special Instructions");

/* If e-mail is not valid show error message */
if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/", $email))
{
show_error("Invalid e-mail address");
}

/* Prepare the message! */

$subject = "Virtual Realty order form submission";

$message = "

Someone has sent you an order:

Name: $firstName $lastName
Email: $email
Phone: $phone
Billing Address: $billingAddress

Hosting Package: $hostingPackage

Scan Package: $scanPackage
Scan Address: $scanAddress

Special Instructions: $specialInstructions
";

/* Send the message using mail() function */
mail($myemail, $subject, $message, $header);

/* Redirect visitor to the thank you page */
header('Location: http://www.virtual-realty-llc.com/thankyou.html');
exit();

/* Functions we used */
function check_input($data, $problem='')
{
$data = trim($data);
$data = stripslashes($data);
$data = htmlspecialchars($data);
if ($problem && strlen($data) == 0)
{
show_error($problem);
}
return $data;
}

function show_error($myError)
{
?>
<html>
<body>

<p>Please correct the following error:</p>
<strong><?php echo $myError; ?></strong>
<p>Hit the back button and try again</p>

</body>
</html>
<?php
exit();
}
?>