terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "19.21.0"

  cluster_name    = "mykubernetes-g3"
  cluster_version = "1.30"

  vpc_id     = var.vpc_id
  subnet_ids = var.private_subnet_ids   # uniquement les subnets privés

  cluster_endpoint_public_access  = true

  eks_managed_node_groups = {
    workers = {
      desired_size = 2
      min_size     = 1
      max_size     = 4
      instance_types = ["t3.medium"]
      capacity_type  = "SPOT"   # très peu cher
    }
  }
}

output "cluster_name" {
  value = module.eks.cluster_name
}

output "commande_kubeconfig" {
  value = "aws eks update-kubeconfig --name ${module.eks.cluster_name} --region us-east-1"
}