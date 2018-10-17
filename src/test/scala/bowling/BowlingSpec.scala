package bowling

import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {
	describe("Pin"){
		val bowling=new Bowling()
		it("hit 0 pin, should return 0"){
			
			val l=List(List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==0)
		}
		it("hit only a pin at the first frame should return 1"){
			val l=List(List(1,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==1)
		}
		it("hit a pin the last frame should return 1"){
			val l=List(List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,1))
			assert(bowling.computeScore(l,l.tail,0)==1)
		}
		it("hit multiple pins should return the correct score "){
			val l=List(List(4,0),List(2,3),List(0,3),List(8,0),List(2,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,1))
			assert(bowling.computeScore(l,l.tail,0)==23)
		}
	}

	describe("spare"){
		val bowling=new Bowling()
		it("hit a spare and after 2 pins should return 14"){
			val l=List(List(1,9),List(2,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==14)
		}
	}

	describe("strike"){
		val bowling=new Bowling()
		it("hit a strike and after 5 pins should return 20"){
			val l=List(List(10,0),List(2,3),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==20)
		}
		it("hit 2 strike in row and after 8 pins should return 54"){
			val l=List(List(10,0),List(0,10),List(5,3),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==54)
		}
		it("hit 3 strike in row and after 4 pins should return 72"){
			val l=List(List(10,0),List(0,10),List(10,0),List(4,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==72)
		}
		it("hit a strike then a spare  and after 8 pins should return 46"){
			val l=List(List(10,0),List(4,6),List(8,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0),List(0,0))
			assert(bowling.computeScore(l,l.tail,0)==46)
		}
	}

}
