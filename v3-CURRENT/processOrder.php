<?php
/* Set e-mail recipient */
$myemail = "virtualrealtyllc@gmail.com";
$header = "From: $myemail \r\n";

/* Check all form inputs using check_input function */
$name = check_input($_POST['inputName'], "Your Name");
$email = check_input($_POST['inputEmail'], "Your E-mail Address");
$phone = check_input($_POST['inputPhone'], "Your Phone Number");
$subject = check_input($_POST['inputSubject'], "Message Subject");
$message = check_input($_POST['inputMessage'], "Your Message");

/* If e-mail is not valid show error message */
if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/", $email))
{
show_error("Invalid e-mail address");
}

/* Prepare the message! */

$subjects = "Virtual Realty contact form submission";

$message = "

Someone has sent you a message using your contact form:

Name: $name
Email: $email
Phone: $phone
Subject: $subject

Message:
$message

";

/* Send the message using mail() function */
mail($myemail, $subjects, $message, $header);

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