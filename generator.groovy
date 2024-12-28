import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

// For generator file - this line is only to have the generator variable
def generator = "windows"

// Load the file as JSON
def generator_json = new JsonSlurper().parse(new File("${generator}.json"))
def latest_version = new File("version.txt").text.trim()

// Read existing data if the file exists, otherwise initialize as empty JSON
def output_file_name = "auto-generated/${generator}.json"
def output_file = new File(output_file_name)
def existing_data = output_file.exists() ? new JsonSlurper().parse(output_file) : [:]

// Build a new map to hold the resource versions
def resource_versions = [:]

// Iterate over resources and extract versions
generator_json["resources"].each { resource_key, resource_value ->
    resource_versions[resource_key] = resource_value["version"]
}

// Add the latest version to the existing data
existing_data[latest_version] = resource_versions

// Write updated JSON to the output file
def updated_json = new JsonBuilder(existing_data).toPrettyString()
output_file.text = updated_json  // This will overwrite the file with the merged data

// Print the final JSON (optional)
println("Updated JSON written to '${output_file_name}':")

