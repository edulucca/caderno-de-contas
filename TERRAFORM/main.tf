provider "aws" {
    version = "~> 2.0"
    region = var.region
}

terraform {
    required_version = "1.4.1"
    required_providers {
        aws = {
            source  = "hashicorp/aws"
            version = "4.16"
        }
    }
}