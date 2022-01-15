find ./source -name "*.java" > source.list
javac -cp ./source/ -d ./executable/ @source.list
