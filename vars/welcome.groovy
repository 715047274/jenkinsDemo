@Grab(group='commons-lang', module='commons-lang', version='2.4')
import org.apache.commons.lang.WordUtils

def call(name){
    echo "Hey ${WordUtils.capitalize(name)}, How are you????"
}

