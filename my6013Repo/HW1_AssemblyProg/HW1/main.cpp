
extern "C" {

  void sayHello();
  void myPuts(const char* s , int len);

}

int main(){

	sayHello();
	myPuts("Hello",5);
	myPuts("Varun",5);
	myPuts("See you",2);
	return 0;
}
