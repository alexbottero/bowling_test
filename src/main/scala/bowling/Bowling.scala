package bowling

class Bowling{


	def addRoll(pin:Int,frame:List[Int]):List[Int]={
		frame:+pin
	}
	def addFrame(frame:List[Int],list:List[List[Int]]):List[List[Int]]={
		list:+frame
	}

	def strike(rolls:List[List[Int]],numFrame:Int):Int={

		if(rolls.isEmpty||numFrame==2) 0
		else if(rolls.length==1)lastFrame(rolls.head,"Strike")
		else if (rolls.head.contains(10))10+strike(rolls.tail,numFrame+1)
		else rolls.head.head+rolls.head.tail.head
	}

	def spare(rolls:List[List[Int]]):Int={
		if(rolls.isEmpty) 0
		else rolls.head.head
	}
	def lastFrame(l:List[Int],typeShot:String):Int={
		if(l.isEmpty) 0
		else if (typeShot=="Spare"){
			2//if(l.head+l.tail.head==10)10+l.tail.tail.head	
		}
		else 
		{
			if(l.head==10) 10+lastFrame(l.tail,"Strike")
			else l.head+lastFrame(l.tail,"Spare")
		}
	}


	def computeScore(rolls:List[List[Int]],remainingRolls:List[List[Int]],score:Int):Int={

		if (rolls.isEmpty){
			score
		}
		else if(remainingRolls.isEmpty){
			val scoreUpt= score+rolls.head.head+rolls.head.tail.head
			computeScore(rolls.tail,remainingRolls,scoreUpt)
		}

		else if(rolls.head.contains(10)){
				val scoreUpt=score+10+strike(remainingRolls,0)
				computeScore(rolls.tail,remainingRolls.tail,scoreUpt)
			
		}
		else if(rolls.head.head+rolls.head.tail.head==10){
				val scoreUpt=score+10+spare(remainingRolls)
				computeScore(rolls.tail,remainingRolls.tail,scoreUpt)
		}
		else{
			val scoreUpt=score+rolls.head.head+rolls.head.tail.head
			computeScore(rolls.tail,remainingRolls.tail,scoreUpt)
		}

	}
}

