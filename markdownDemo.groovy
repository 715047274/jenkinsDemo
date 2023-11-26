//def filePath = "C:\\ProgramData\\Jenkins\\.jenkins\\jobs\\LocalPipeline\\builds\\131\\log"
def outputFilePath = "C:\\ProgramData\\Jenkins\\.jenkins\\jobs\\LocalPipeline\\builds\\131\\cypress-report2.txt"
def inputFilePath = "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\LocalPipeline\\cypress-report.txt"

// Read the content of the input file with UTF-8 encoding
def fileContent = new File(inputFilePath).getText('UTF-8')

// Define a regular expression pattern for extracting the relevant block
def blockRegex = /┌─+[\s\S]+?┘/

// Find all occurrences of the relevant block in the file
def matcher  = (fileContent =~ blockRegex)

if (matcher instanceof java.util.regex.Matcher) {
 // Extract all matched block content
 def blockContentList = matcher.results().collect { it.group(0).trim() }

 // Join the extracted blocks with double newline characters as separators
 def allBlocksContent = blockContentList.join('\n\n')

 // Write the extracted block content to the output file
 new File(outputFilePath).write(allBlocksContent, 'UTF-8')

 println("All relevant blocks have been written to the output file.")
} else {
 println("No relevant blocks found in the input file.")
}