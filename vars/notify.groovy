def call(status) {
	node {
		emailext (
            to: "kumar.vinothvijay@gmail.com",
            subject: "${status} Job Successful '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>${status}  Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                <p>console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>"""
            )
	}
}
