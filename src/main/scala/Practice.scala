sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](values: A*): List[A] = {
    if (values.isEmpty) Nil
    else Cons(values.head, apply(values.tail: _*))
  }

  def sum[A <: Int](a: List[A]): Int = a match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def tail[A](a: List[A]): List[A] = a match {
    case Nil => a
    case Cons(x, xs) => xs
  }

  def setHead[A](l: List[A], a: A): List[A] = l match {
    case Cons(x, xs) => Cons(a, xs)
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    def use[A](l1: List[A], n1: Int): List[A] = {
      if (n1 == 0)
        l1
      else {
        l1 match {
          case Nil => l1
          case Cons(x, xs) => use(xs, n1 - 1)
        }
      }
    }
    use(l, n)
  }

  def append[A](l1: List[A], l2: List[A]): List[A] = l1 match {
    case Nil => l2
    case Cons(x, xs) => Cons(x, append(xs, l2))
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(x, xs) => if (f(x)) dropWhile(xs)(f) else l
  }

  def operate[A,B](a:List[A],z:B)(f:(A,B) => B):B = a match {
    case Nil => z
    case Cons(x,xs) if x == 0 => {
      println("Recursion Stopped...")
      f(x,operate(Nil,z)(f))
    }
    case Cons(x,xs) => {
      println("Continuing....")
      f(x,operate(xs,z)(f))
    }
  }
}

class SuperMe {
  def apply() = {}
}

case class Child() extends SuperMe

List.operate(List(1,2,3,4,6),0)(_ + _)
List.operate(List(1,2,0,4),0.0)(_ * _)

val list: List[SuperMe] = List(Child())

List.sum(List(1, 2, 3, 7))

List.drop(List(1, 2, 3, 4), 1)

List.dropWhile(List(1, 2, 3, 4))((a) => a < 2)

List.append(List(1, 2, 3, 4), List(5, 6, 7))

