<%@ page import="java.util.* ,dal.asdc.ludo_board_structure.Token_positions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="ludo_board.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ludo Game</title>
</head>
<body>
<%	
	Map<String,String> red_token_positions_map = new HashMap<String,String>();
	Token_positions tkn_pos=new Token_positions();
	tkn_pos.get_red_token_positions();
	red_token_positions_map = tkn_pos.get_red_token_positions();
%>
<div class="game">
    <div class="house green">
        <div class="box">
            <div class="square square-one green">G1</div>
            <div class="square square-two green">G2</div>
            <div class="square square-three green">G3</div>
            <div class="square square-four green">G4</div>
        </div>
    </div>

    <div class="house yellow" style="right: 0">
        <div class="box">
            <div class="square square-one yellow">Y1</div>
            <div class="square square-two yellow">Y2</div>
            <div class="square square-three yellow">Y3</div>
            <div class="square square-four yellow">Y4</div>
        </div>
    </div>

    <div class="house red" style="bottom: 0">
        <div class="box">
            <div class="square square-one red"><%=red_token_positions_map.get("{2,3}")%></div>
            <div class="square square-two red"><%=red_token_positions_map.get("{3,3}")%></div>
            <div class="square square-three red"><%=red_token_positions_map.get("{3,2}")%></div>
            <div class="square square-four red"><%=red_token_positions_map.get("{2,2}")%></div>
        </div>
    </div>

    <div class="house blue" style="bottom: 0;right: 0">
        <div class="box">
            <div class="square square-one blue">B1</div>
            <div class="square square-two blue">B2</div>
            <div class="square square-three blue">B3</div>
            <div class="square square-four blue">B4</div>
        </div>
    </div>

    <div class="home"></div>
    <div class="cells" style="top: 40%;"></div>
    <div class="cells g-start" style="top: 40%;left:6.66%;"></div>
    <div class="cells" style="top: 40%;left:13.32%;"></div>
    <div class="cells" style="top: 40%;left:19.98%;"></div>
    <div class="cells" style="top: 40%;left:26.64%;"></div>
    <div class="cells" style="top: 40%;left:33.3%;"></div>

    <div class="cells" style="top: 0;left:40%;"></div>
    <div class="cells" style="top: 6.66%;left:40%;"></div>
    <div class="cells safe" style="top: 13.32%;left:40%;"></div>
    <div class="cells" style="top: 19.98%;left:40%;"></div>
    <div class="cells" style="top: 26.64%;left:40%;"></div>
    <div class="cells" style="top: 33.3%;left:40%;"></div>

    <div class="cells" style="top: 0;left:46.66%;"></div>
    <div class="cells yellow" style="top: 6.66%;left:46.66%;"></div>
    <div class="cells yellow" style="top: 13.32%;left:46.66%;"></div>
    <div class="cells yellow" style="top: 19.98%;left:46.66%;"></div>
    <div class="cells yellow" style="top: 26.64%;left:46.66%;"></div>
    <div class="cells yellow" style="top: 33.3%;left:46.66%;"></div>

    <div class="cells" style="top: 0;left:53.32%;"></div>
    <div class="cells y-start" style="top: 6.66%;left:53.32%;"></div>
    <div class="cells" style="top: 13.32%;left:53.32%;"></div>
    <div class="cells" style="top: 19.98%;left:53.32%;"></div>
    <div class="cells" style="top: 26.64%;left:53.32%;"></div>
    <div class="cells" style="top: 33.3%;left:53.32%;"></div>

    <div class="cells" style="top: 40%; right: 33.3%"></div>
    <div class="cells" style="top: 40%;right:26.64%;"></div>
    <div class="cells" style="top: 40%;right:19.98%;"></div>
    <div class="cells safe" style="top: 40%;right:13.32%;"></div>
    <div class="cells" style="top: 40%;right:6.66%;"></div>
    <div class="cells" style="top: 40%;right:0;"></div>

    <div class="cells blue" style="top: 46.66%; right: 33.3%"></div>
    <div class="cells blue" style="top: 46.66%;right:26.64%;"></div>
    <div class="cells blue" style="top: 46.66%;right:19.98%;"></div>
    <div class="cells blue" style="top: 46.66%;right:13.32%;"></div>
    <div class="cells blue" style="top: 46.66%;right:6.66%;"></div>
    <div class="cells" style="top: 46.66%;right:0;"></div>

    <div class="cells" style="top: 53.32%; right: 33.3%"></div>
    <div class="cells" style="top: 53.32%;right:26.64%;"></div>
    <div class="cells" style="top: 53.32%;right:19.98%;"></div>
    <div class="cells" style="top: 53.32%;right:13.32%;"></div>
    <div class="cells b-start" style="top: 53.32%;right:6.66%;"></div>
    <div class="cells" style="top: 53.32%;right:0;"></div>

    <div class="cells" style="bottom: 0;left:53.32%;"></div>
    <div class="cells" style="bottom: 6.66%;left:53.32%;"></div>
    <div class="cells safe" style="bottom: 13.32%;left:53.32%;"></div>
    <div class="cells" style="bottom: 19.98%;left:53.32%;"></div>
    <div class="cells" style="bottom: 26.64%;left:53.32%;"></div>
    <div class="cells" style="bottom: 33.3%;left:53.32%;"></div>

    <div class="cells" style="bottom: 0;left:46.66%;"></div>
    <div class="cells red " style="bottom: 6.66%;left:46.66%;"></div>
    <div class="cells red" style="bottom: 13.32%;left:46.66%;"></div>
    <div class="cells red" style="bottom: 19.98%;left:46.66%;"></div>
    <div class="cells red" style="bottom: 26.64%;left:46.66%;"></div>
    <div class="cells red" style="bottom: 33.3%;left:46.66%;"></div>

    <div class="cells" style="bottom: 0;left:40%;"></div>
    <div class="cells r-start" style="bottom: 6.66%;left:40%;"></div>
    <div class="cells" style="bottom: 13.32%;left:40%;"></div>
    <div class="cells" style="bottom: 19.98%;left:40%;"></div>
    <div class="cells" style="bottom: 26.64%;left:40%;"></div>
    <div class="cells" style="bottom: 33.3%;left:40%;"></div>

    <div class="cells" style="top: 53.32%; left: 33.3%"></div>
    <div class="cells" style="top: 53.32%;left:26.64%;"></div>
    <div class="cells" style="top: 53.32%;left:19.98%;"></div>
    <div class="cells safe" style="top: 53.32%;left:13.32%;"></div>
    <div class="cells" style="top: 53.32%;left:6.66%;"></div>
    <div class="cells" style="top: 53.32%;left:0;"></div>

    <div class="cells green" style="top: 46.66%;left: 33.3%"></div>
    <div class="cells green" style="top: 46.66%;left:26.64%;"></div>
    <div class="cells green" style="top: 46.66%;left:19.98%;"></div>
    <div class="cells green" style="top: 46.66%;left:13.32%;"></div>
    <div class="cells green" style="top: 46.66%;left:6.66%;"></div>
    <div class="cells" style="top: 46.66%;left:0;"></div>


</div>

</body>
</html>