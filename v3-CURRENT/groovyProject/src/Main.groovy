/**
 * Created by: scottgildersleeve
 * Date: 23 Apr 2015
 */
class Main {

    public static void main(String[] args) {
        def binding = [streetAddress: '116 Nassau Street',
                       fullAddress: '116 Nassau Street, Charleston, SC 29403',
                       propertyType: 'Multiple Occupancy',
                       buildingType: 'House',
                       numStories: '2',
                       parkingType: 'On-street',
                       numBeds: '4',
                       numBaths: '4 half',
                       squareFootage: '1,952',
                       askingPrice: '$X,000 per month',
                       description: "Built in 1885, this 1,952-square-foot Charleston single home is located in downtown Charleston, just one block from Meeting Street and within easy walking distance of Martin Park.",
                       amenities: 'Fireplace, full kitchens upstairs and down, near Martin and Marion Square Parks',
                       realtorLink: 'http://www.zillow.com/homedetails/116-Nassau-St-Charleston-SC-29403/10905892_zpid/',
                       modelId: '4mP6GBuwChY']

        def engine = new groovy.text.SimpleTemplateEngine()
        def text = '''\
<!DOCTYPE html>
<html lang="en">
\t<!-- Head -->
\t<head>
\t\t<meta charset="utf-8">
\t\t<meta http-equiv="X-UA-Compatible" content="IE=edge">
\t\t<meta name="viewport" content="width=device-width, initial-scale=1">

\t\t<title>Virtual Realty LLC | You're Virtually There</title>

\t\t<!-- Favicon -->
\t\t<link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
\t\t<link rel="icon" href="../../favicon.ico" type="image/x-icon">
\t\t
\t\t <!-- Bootstrap -->
\t    <link href="../../css/bootstrap.min.css" rel="stylesheet">
\t    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
\t    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
\t    <!--[if lt IE 9]>
\t      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
\t      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
\t    <![endif]-->

\t\t<!-- Site Styles -->
\t\t<link href="../../css/styles.css" rel="stylesheet">
\t\t<link href="../../fonts/font-awesome-4.2.0/css/font-awesome.min.css" rel="stylesheet">
\t\t<link href='http://fonts.googleapis.com/css?family=Vollkorn' rel='stylesheet' type='text/css'>
\t\t
\t\t<!-- Google Analytics -->
\t\t<script>
\t\t  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
\t\t  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
\t\t  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
\t\t  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

\t\t  ga('create', 'UA-59443154-1', 'auto');
\t\t  ga('send', 'pageview');

\t\t</script>
\t</head>
\t<!-- Body -->
\t<body style="background-color: #f8f8ff;">
\t\t<!-- Navigation -->
\t\t<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
\t        <div class="container-fluid">
\t          <!-- Brand and toggle get grouped for better mobile display -->
\t          <div class="navbar-header">
\t            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse-nav">
\t              <span class="sr-only">Toggle navigation</span>
\t              <span class="icon-bar"></span>
\t              <span class="icon-bar"></span>
\t              <span class="icon-bar"></span>
\t            </button>
\t            <a class="navbar-brand" href="../../index.html"><img src="../../img/logo_horizontal.png" title="Virtual Realty LLC"></a>
\t          </div>
\t          <!-- Collect the nav links, forms, and other content for toggling -->
\t          <div class="collapse navbar-collapse" id="collapse-nav">
\t            <ul class="nav navbar-nav navbar-right">
\t              <li class="nav-demo"><a href="../../demo.html">DEMO</a></li>
\t              <li class="nav-portfolio"><a href="../../portfolio.html">PORTFOLIO</a></li>
\t              <li class="nav-pricing"><a href="../../pricing.html">PRICING</a></li>
\t              <li class="nav-order"><a href="../../order.html"><span id="order">ORDER</span></a></li>
\t            </ul>
\t          </div><!-- /.navbar-collapse -->
\t        </div><!-- /.container-fluid -->
      \t</nav>
\t\t
\t\t<!-- Demo Embed -->
      \t<div class="demo">
      \t\t<div class='embed-container'>
\t\t\t\t<iframe width="853" height="480" src="https://my.matterport.com/show/?m=$modelId" frameborder="0" allowfullscreen></iframe>\t\t\t
\t\t\t</div>
      \t</div>

      \t<div class="instructions">
      \t\t<p>Navigate the 3D Showcase using your mouse or the direction keys on your keyboard.</p>
      \t</div>

      \t<div class="demo-listing" style="padding: 0 2em 4em 2em;">
      \t\t<h2>$fullAddress</h2>
      \t\t<h4>$numBeds bedrooms / $numBaths bathrooms | $squareFootage sq. ft. | <span style="color: #dc143c;">$askingPrice</span> | <a href="$realtorLink" target="_blank">Learn More</a> </h4>
      \t\t<div class="row listing" style="min-height:270px;">
      \t\t\t<div class="col-md-3 col-sm-3 col-xs-12"></div>
\t      \t\t<div class="col-md-3 col-sm-3 col-xs-12">
\t      \t\t\t<h5>Description</h5>
\t      \t\t\t<p>$description</p>
\t      \t\t</div>
\t      \t\t<div class="col-md-3 col-sm-3 col-xs-12">
\t      \t\t\t<h5 style="padding-left: 40px;">Facts</h5>
\t      \t\t\t<ul>
\t      \t\t\t\t<li><b>Property Type:</b> $propertyType</li>
\t\t\t\t\t\t<li><b>Building Type:</b> $buildingType</li>
\t\t\t\t\t\t<li><b>Stories:</b> $numStories</li>
\t\t\t\t\t\t<li><b>Parking:</b> $parkingType</li>
\t\t\t\t\t\t<li><b>Amenities:</b> $amenities</li>
\t      \t\t\t</ul>
\t      \t\t</div>
\t      \t\t<div class="col-md-3 col-sm-3 col-xs-12"></div>
\t      \t</div>
      \t</div>
\t\t<!-- Footer -->
\t\t<div class="row footer" style="position:relative; top:480px;">
\t\t\t<div class="col-xs-12">
\t\t\t\t<div class="col-md-4 col-sm-4">
\t\t\t\t\t<div class="col-md-6 col-sm-6 col-xs-6 site-map">
\t\t\t\t\t\t<p><a href="../../demo.html">DEMO</a></p>
\t\t\t\t\t\t<p><a href="../../pricing.html">PRICING</a></p>
\t\t\t\t\t\t<p><a href="../../order.html">ORDER</a></p>
\t\t\t\t\t\t<p><a href="../../faq.html">FAQ</a></p>
\t\t\t\t\t</div>
\t\t\t\t\t<div class="col-md-6 col-sm-6 col-xs-6 site-map" style="margin-left: -5%;" id="industry">
\t\t\t\t\t\t<p style="font-weight:500;">INDUSTRY</p>
\t\t\t\t\t\t<ul>
\t\t\t\t\t\t\t<li><a href="../../industry/realestate.html">REAL ESTATE</a></li>
\t\t\t\t\t\t\t<li><a href="../../industry/construction.html">CONSTRUCTION</a></li>
\t\t\t\t\t\t\t<li><a href="../../industry/insurance.html">INSURANCE</a></li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class="col-md-4 col-sm-4 col-xs-6 contact">
\t\t\t\t\t<p><a href="mailto:info@virtual-realty-llc.com">CONTACT</a></p>
\t\t\t\t\t<p><span class="fa fa-phone contact-icon"></span>843.608.8606</p>
\t\t\t\t\t<p><a href="mailto:info@virtual-realty-llc.com" class="fa fa-envelope contact-icon"><span style="padding-left:0.5em;">info@virtual-realty-llc.com</span></a></p>
\t\t\t\t\t<p><span class="fa fa-home contact-icon"></span>Charleston, SC</p>
\t\t\t\t</div>
\t\t\t
\t\t\t\t<div class="col-md-4 col-sm-4 col-xs-6">
\t\t\t\t\t<p style="font-weight:500;">ABOUT</p>
\t\t\t\t\t<p>Virtual Realty LLC is a premium provider of <a href="http://www.matterport.com" style="font-weight: 200;">Matterport 3D Showcases</a>.</p>
\t\t\t\t\t<div class="tagline">You're Virtually There.</div>
\t\t\t\t\t<div class="social">
\t\t\t\t\t\t<a href="https://www.linkedin.com/company/virtual-realty-llc" class="fa fa-linkedin social-icon"></a>
\t\t\t\t\t\t<a href="https://www.facebook.com/VirtualRealtyLLC" class="fa fa-facebook social-icon"></a>
\t\t\t\t\t</div> <!-- ./social -->
\t\t\t\t</div>
\t\t\t</div>
\t\t\t<div class="col-md-12" style="text-align: center; padding-top: 2em;">
\t\t\t\t<p><span class="fa fa-copyright social-icon"></span>2014 Virtual Realty LLC. All rights reserved. <a href="../../legal/termsUse.html" style="font-weight: 200;">Terms of Use</a>. <a href="../../legal/privacyPolicy.html" style="font-weight: 200;">Privacy Policy</a>.</p>
\t\t\t</div>
\t\t</div> <!-- ./footer -->

\t\t<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
\t    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
\t    <!-- Include all compiled plugins (below), or include individual files as needed -->
\t    <script src="../../js/bootstrap.min.js"></script>
\t</body>
</html>
'''


        def template = engine.createTemplate(text).make(binding)
        println template.toString()
    }




}
