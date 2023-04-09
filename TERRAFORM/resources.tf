resource "aws_instance" "server" {
  instance_type = var.instanceType
  ami           = var.imageId
  tags = {
    Name        = var.name
    Environment = var.env
    Provisioner = "Terraform"
    Repo        = var.repo
  }
}